package task2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteDetails {

	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("guru");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		
		
		EmployeeDetails ed=em.find(EmployeeDetails.class, 1);
		
		
        if (ed!=null) {
			
			et.begin();
			em.remove(ed);
			et.commit();
			
			System.out.println("Deleted");
		} else {
			
			System.out.println("Id not found");

		}

	}

}
