package task2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class GetDetails {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		
		EmployeeDetails ed=em.find(EmployeeDetails.class, 1);
		
		System.out.println(ed);
	}

}
