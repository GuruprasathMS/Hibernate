package hibernate;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UsingLike {

	public static void main(String[] args) {
//		Scanner s=new Scanner(System.in);
//		System.out.println("Enter the name:");
//		String name=s.next();
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		
//		Query q=em.createQuery("select u from User u where u.name like ?1");
//		
//		q.setParameter(1, name);
        
		
		Query q=em.createQuery("select u from User u where u.name like '%tom'");
		
//		q.setParameter("name", name);
		
		List<User> u = q.getResultList();
		
//		System.out.println(u);
		
		for (User u1 : u) {
			System.out.println(u1);
		}

	}

}
