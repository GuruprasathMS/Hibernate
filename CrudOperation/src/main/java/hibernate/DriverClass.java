package hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DriverClass {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		User u=new User();
		u.setUid(2);
		u.setName("jerry");
		u.setEmail("jerry@gmail.com");
		u.setPassword("456");
		u.setPhone(198746525);
		
		et.begin();
		em.persist(u); 
		et.commit();

	}

}
