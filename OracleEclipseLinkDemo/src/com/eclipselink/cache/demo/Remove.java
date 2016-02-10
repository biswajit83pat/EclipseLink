package com.eclipselink.cache.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.eclipselink.demo.Student;

public class Remove {
	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("OracleEclipseLinkDemo");
		EntityManager em = emFactory.createEntityManager();

		Student st1 = em.find(Student.class, 4L);

		em.getTransaction().begin();
		em.remove(st1);
		em.getTransaction().commit();

	}
}
