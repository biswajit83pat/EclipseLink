package com.eclipselink.cache.nosql.demo.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.JoinField;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@NoSql(dataType = "orders", dataFormat = DataFormatType.MAPPED)
public class Order {
	@Id
	//@GeneratedValue
	@Field(name = "_id")
	private long id;
	@Basic
	@Field(name = "description")
	private String description;
	@Embedded
	@Field(name = "deliveryAddress")
	private Address deliveryAddress;
	@ElementCollection
	@Field(name = "orderLines")
	private List<OrderLine> orderLines;
	// @ManyToOne
	@JoinField(name = "customerId")
	private Customer customer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}