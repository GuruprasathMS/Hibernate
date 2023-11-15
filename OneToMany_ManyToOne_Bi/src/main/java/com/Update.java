package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class Update {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Passenger p=em.find(Passenger.class, 3);
		p.setMobile(84465487);
		
		try {
			et.begin();
			em.merge(p);
			et.commit();
			
			System.out.println("Updated");
		} catch (Exception e) {
		    e.printStackTrace();
		    et.rollback();
		}
		

	}

}
