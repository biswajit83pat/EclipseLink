package com.eclipselink.cache.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.eclipselink.demo.Student;

public class Update {
	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("OracleEclipseLinkDemo");
		EntityManager em = emFactory.createEntityManager();

		//Student st1 = new Student();
		Student st1 = em.find(Student.class, 4L);
		
		st1.setName("changed");

		em.getTransaction().begin();
		em.merge(st1);
		em.getTransaction().commit();

	}
}
