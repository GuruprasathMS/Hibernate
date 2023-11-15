package hibernate;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchByName {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your name:");
		String name = s.next();
		
	
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		
		//Position Parameter
		Query q=em.createQuery("select u from User u where u.name=?5");
		q.setParameter(5, name);
		
		
		List<User> u= q.getResultList();
		
		System.out.println(u);

	}

}
