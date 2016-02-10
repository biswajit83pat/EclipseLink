package com.eclipselink.cache.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.jpa.jpql.Assert;

import com.eclipselink.demo.Student;

public class CacheReadOnly {
	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("OracleEclipseLinkDemo");
		EntityManager em = emFactory.createEntityManager();

		//Student st1 = new Student();
		Student st1 = em.find(Student.class, 4L);
		
		em = emFactory.createEntityManager();
		Student st2 = em.find(Student.class, 4L);
		
		//Assert.isEqual(st1, st2, "Not Equal");
		//st1.setName("changed");

		//em.getTransaction().begin();
		//em.persist(st1);
		//em.getTransaction().commit();

	}
}
