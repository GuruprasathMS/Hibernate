package com;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Flight f=new Flight();
		 f.setName("Dubai Boeing 743");
		 f.setPrice(60000);
		 f.setCapacity(250);
		 f.setDeparture("Bangalore");
		 f.setArrival("Dubai");
		 
		 Passenger p1=new Passenger();
		 p1.setName("Pravin");
		 p1.setMobile(465464646);
		 p1.setAge(20);
		 p1.setGender("Male");
		 p1.setFlight(f);
		 
		 Passenger p2=new Passenger();
		 p2.setName("Raja");
		 p2.setMobile(565546554);
		 p2.setAge(27);
		 p2.setGender("Male");
		 p2.setFlight(f);
		 
		 ArrayList<Passenger> al=new ArrayList<Passenger>();
		 al.add(p1);
		 al.add(p2);
		 
		 
		 f.setPassenger(al);
		
		try {
			et.begin();
			em.persist(p1);
			em.persist(p2);
			em.persist(f);
			et.commit();
		} catch (Exception e) {
            e.printStackTrace();
            et.rollback();
		}
	}

}
