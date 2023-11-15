package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class Delete {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Passenger p1=em.find(Passenger.class, 5);
		
		
		if (p1!=null) {
			
			Flight f=p1.getFlight();
		
			et.begin();
			em.remove(p1);
			et.commit();
			
			System.out.println("Deleted");
		} else {
			et.rollback();
			System.out.println("ID not found");

		}


	}

}
