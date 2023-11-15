package hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Delete {

	public static void main(String[] args) {
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("guru");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		
		User u=em.find(User.class, 0);
		
		if (u!=null) {
			
			et.begin();
			em.remove(u);
			et.commit();
			
			System.out.println("Deleted");
		} else {
			
			System.out.println("Id not found");

		}

	}

}
