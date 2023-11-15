package manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class Delete {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Employee e1=em.find(Employee.class, 7);
		Employee e2=em.find(Employee.class, 8);
		Employee e3=em.find(Employee.class, 9);
		
		if (e1!=null || e2!=null || e3!=null) {
			
			Company c1=e1.getCompany();
			Company c2=e2.getCompany();
			Company c3=e3.getCompany();
			et.begin();
			em.remove(e1);
			em.remove(e2);
			em.remove(e3);
			em.remove(c1);
			em.remove(c2);
			em.remove(c3);
			et.commit();
			
			System.out.println("Deleted");
		} else {
			et.rollback();
			System.out.println("ID not found");

		}

	}

}
