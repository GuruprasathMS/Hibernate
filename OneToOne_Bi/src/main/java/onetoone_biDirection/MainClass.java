package onetoone_biDirection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainClass {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Address a=new Address();
		a.setStreet("Sowrashtra Nagar");
		a.setDistrict("Chennai");
		a.setArea("Choolaimedu");
		a.setPincode(600096);
		
		User u=new User();
		u.setName("Vignesh");
		u.setEmail("vicky@gmail.com");
		u.setPass("vicky123");
		u.setPhone(8465645682l);
		
		u.setA(a);
		a.setU(u);
		
		try {
			et.begin();
			em.persist(u);
			em.persist(a);
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
		}
		
		

	}

}
