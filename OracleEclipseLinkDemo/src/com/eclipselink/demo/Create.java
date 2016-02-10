package com.eclipselink.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Create {
	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("OracleEclipseLinkDemo");
		EntityManager em = emFactory.createEntityManager();

		Student st1 = new Student();
		st1.setId(4L);
		st1.setName("demo1");

		em.getTransaction().begin();
		em.persist(st1);
		em.getTransaction().commit();

	}
}
