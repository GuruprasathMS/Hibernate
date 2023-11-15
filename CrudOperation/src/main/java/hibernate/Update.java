package hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Update {

	public static void main(String[] args) {
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		User u= new User();
//		u.setUid(4);
//		u.setName("jack");
//		u.setEmail("joshwa@gmail.com");
//		u.setPassword("258");
		
//		u.setPhoneNumber(8484686511l);
		
		User u1=em.find(User.class, 4);
		
//		u.setPassword("89756");
		
		et.begin();
		em.merge(u);
		et.commit();
	}

}
