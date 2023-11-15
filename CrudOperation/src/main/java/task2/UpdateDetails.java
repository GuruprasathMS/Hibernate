package task2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateDetails {

	public static void main(String[] args) {
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		EmployeeDetails ed=em.find(EmployeeDetails.class, 1);
		
		ed.setJob("Team Leader");
		
		et.begin();
		em.merge(ed);
		et.commit();
	}

}
