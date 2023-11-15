package hibernate;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindBetweenUid {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Starting Range:");
		int start = s.nextInt();
		System.out.println("Enter the ending Range:");
		int end = s.nextInt();
		
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		
//		Query q=em.createQuery("select u from User u where u.uid between ?1 and ?2");
//		q.setParameter(1,start);
//		q.setParameter(2,end);
		
		Query q=em.createQuery("select u from User u where u.uid between :start and :end");
		q.setParameter("start",start);
		q.setParameter("end",end);
		
		List<User> u=q.getResultList();
		
		System.out.println(u);
		
//		for (User u1 : u) {
//			
//			System.out.println(u);
//			
//		}
		
		
		
	}
}
