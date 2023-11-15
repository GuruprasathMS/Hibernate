package hibernate;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchOnlyName {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		
		Query q = em.createQuery("select u from User u where phone=1234567890");
		
		Object obj=q.getSingleResult();
		
		//EmployeeDetails ed=(EmployeeDetails) q.getSingleResult();
		System.out.println(obj);
	}

}
