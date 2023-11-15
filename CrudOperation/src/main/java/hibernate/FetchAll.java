package hibernate;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class FetchAll {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		
		Query q=em.createQuery("select u from User u");
		
		List<User> u=q.getResultList();
		
		for (User u1 : u) {
			
			System.out.println(u1);
		}
		
				

	}

}
