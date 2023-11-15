package onetomany_uniDirectional;

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
		
		SimCards s1=new SimCards();
		s1.setBrand("Airtel");
		s1.setBand("5g");
		
		SimCards s2=new SimCards();
		s2.setBrand("Vodafone");
		s2.setBand("4g");
		
		ArrayList<SimCards> al=new ArrayList<SimCards>();
		al.add(s1);
		al.add(s2);
		
		Mobile m=new Mobile();
		m.setBrand("Oneplus");
		m.setModel("CE3");
		m.setPrice(29999.0);
		m.setSimcards(al);
		
		et.begin();
		em.persist(m);
		em.persist(s1);
		em.persist(s2);
		et.commit();
		
	
		
	}

}
