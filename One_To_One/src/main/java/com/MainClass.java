package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainClass {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		AadharCard a=new AadharCard();
		a.setAno(55622268);
		a.setDOB("09/05/1997");
		a.setAddress("Madurai");
		
		Person p=new Person();
		p.setId(2);
		p.setName("Rajesh");
		p.setGender("Male");
		p.setAge(25);
		p.setMobile(8985653511l);
		p.setC(a);
		
		try {
			et.begin();
			em.persist(p);
			em.persist(a);
			et.commit();
		} catch (Exception e) {
			et.rollback();
		}

	}

}
