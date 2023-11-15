package task2;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class NameAndPhone {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		
		Query q=em.createQuery("select ed.ename,ed.phone from EmployeeDetails ed");
		
		List<Object[]> l=q.getResultList();
		
		for (Object[] obj : l) {
			
			System.out.println("Name : " + obj[0] + "(Phone Number : " + obj[1] +")");
			
		}

	}

}
