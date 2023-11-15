package com;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainClass {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		 Flight f=new Flight();
		 f.setName("Thai Boeing 717");
		 f.setPrice(30000);
		 f.setCapacity(300);
		 f.setDeparture("Chennai");
		 f.setArrival("ThaiLand");
		 
		 Passenger p1=new Passenger();
		 p1.setName("Guru");
		 p1.setMobile(686864645);
		 p1.setAge(26);
		 p1.setGender("Male");
		 p1.setFlight(f);
		 
		 Passenger p2=new Passenger();
		 p2.setName("Prasath");
		 p2.setMobile(46846546);
		 p2.setAge(25);
		 p2.setGender("Male");
		 p2.setFlight(f);
		 
		 Passenger p3=new Passenger();
		 p3.setName("Vijay");
		 p3.setMobile(877987845);
		 p3.setAge(20);
		 p3.setGender("Male");
		 p3.setFlight(f);
		 
		 ArrayList<Passenger> al=new ArrayList<Passenger>();
		 al.add(p1);
		 al.add(p2);
		 al.add(p3);
		 
		 f.setPassenger(al);
		 
		 
		 
		 et.begin();
		 em.persist(p1);
		 em.persist(p2);
		 em.persist(p3);
		 em.persist(f);
		 et.commit();
		 
		 System.out.println("Inserted");
		 
		 

	}

}
