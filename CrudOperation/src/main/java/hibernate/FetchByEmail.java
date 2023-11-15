package hibernate;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchByEmail {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your email:");
		String email = s.next();
		
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		//Named Parameter
		Query q=em.createQuery("select u from User u where u.email=:email");
		q.setParameter("email",email);
		
		
     	User u=(User) q.getSingleResult();
		
        // List<User> u= q.getResultList();
		
//		System.out.println(u.getName());

	}

}
