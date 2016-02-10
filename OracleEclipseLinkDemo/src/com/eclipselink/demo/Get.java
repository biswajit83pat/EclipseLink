package com.eclipselink.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Get {
	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("OracleEclipseLinkDemo");
		EntityManager em = emFactory.createEntityManager();

		Student st1 = em.find(Student.class, 4L);
		
		System.out.println(st1.getName() + " " + st1.getId());
	}
}
