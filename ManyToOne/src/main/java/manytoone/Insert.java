package manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Insert {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Company c=new Company();
		c.setCname("Vedantu");
		c.setLoc("Chennai");
		c.setGstn("VGH5465465546");
		
		Employee e1=new Employee();
		e1.setName("Rajesh");
		e1.setSal(22000);
		e1.setJob("Data Handling");
		e1.setDept("Data Management");
		e1.setCompany(c);
		
		try {
			et.begin();
			em.persist(e1);
			em.persist(c);
			et.commit();
		} catch (Exception e) {
            e.printStackTrace();
            et.rollback();
		}
		
		

	}

}
