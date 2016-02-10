package com.eclipselink.cache.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.eclipse.persistence.internal.nosql.adapters.mongo.MongoConnection;

import com.eclipselink.cache.nosql.demo.model.Address;
import com.eclipselink.cache.nosql.demo.model.Customer;
import com.eclipselink.cache.nosql.demo.model.Order;
import com.eclipselink.cache.nosql.demo.model.OrderLine;
import com.mongodb.DB;

public class TestMongoDB {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("mongo-example").createEntityManager();
		EntityTransaction tx;

		//DB db = ((MongoConnection) em.unwrap(javax.resource.cci.Connection.class)).getDB();
		//db.dropDatabase();
		
		//Create
		System.out.println("After db droppped!!");
		tx = em.getTransaction();
		tx.begin();

		Address ad1 = new Address();
		ad1.setCity("Bangalore");
		ad1.setPostalCode("560037");
		ad1.setCountry("India");
		ad1.setProvince("Karnataka");
		ad1.setStreet("Tulasi Theater Road");
		
		Customer c1 = new Customer();
		//c1.setId(id);
		c1.setName("Biswajit Pathak");
		
		OrderLine ol1 = new OrderLine();
		ol1.setItemName("Ps4 medal of Honour");
		ol1.setLineNumber(1);
		ol1.setQuantity(1);
		
		OrderLine ol2 = new OrderLine();
		ol2.setItemName("Ps4 Destiny");
		ol2.setLineNumber(2);
		ol2.setQuantity(1);

		List<OrderLine> orderLines = new ArrayList<>();
		orderLines.add(ol1);
		orderLines.add(ol2);
		
		Order o1 = new Order();
		o1.setId(1L);
		o1.setCustomer(c1);
		o1.setDeliveryAddress(ad1);
		o1.setDescription("Biswajit's Christmas Order");
		o1.setOrderLines(orderLines);
		
		em.persist(o1);
		
		tx.commit();
		
		System.out.println("Comitted...");
		
		//READ
		
		Order oFromDB = em.find(Order.class, 1L);
		System.out.println("Name --> " + oFromDB.getCustomer().getName() + " country --> " + oFromDB.getDeliveryAddress().getCountry());
		
		//This below line should fail
		System.out.println("Order Line Items -- >" + ((OrderLine)oFromDB.getOrderLines().get(0)).getItemName());
		
		//Trying indirection now
		/*oFromDB.getOrderLines().size();
		List<OrderLine> orderLineLists = oFromDB.getOrderLines(); 
		System.out.println("Order Line Items -- >" + orderLineLists.size());*/
		
		//UPDATE
		
		Customer customerNew = new Customer();
		customerNew.setName("Vaibhav Pathak");
		oFromDB.setCustomer(customerNew);
		
		oFromDB = em.find(Order.class, 1L);
		System.out.println("Update customer Name --> " + oFromDB.getCustomer().getName() + " country --> " + oFromDB.getDeliveryAddress().getCountry());
		
		//DELETE
		tx.begin();
		em.remove(oFromDB);
		tx.commit();
		
		//READ again, should throw exception
		oFromDB = em.find(Order.class, 1L);
		System.out.println("Now that object should be null!!! ==> " + (oFromDB == null));
		
	}
}
