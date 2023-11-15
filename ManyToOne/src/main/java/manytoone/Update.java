package manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Update {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Company c=em.find(Company.class, 1);
		c.setGstn("RTFS56653453453");
		
		try {
			et.begin();
			em.merge(c);
			et.commit();
			
			System.out.println("Updated");
		} catch (Exception e) {
		    e.printStackTrace();
		    et.rollback();
		}
		
	
	}

}
