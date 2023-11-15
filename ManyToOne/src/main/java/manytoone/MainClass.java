package manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainClass {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Company c=new Company();
		c.setCname("Test Yantra");
		c.setLoc("Chennai");
		c.setGstn("GRT54684687651");
		
		Employee e1=new Employee();
		e1.setName("Guru");
		e1.setSal(25000);
		e1.setJob("Developer");
		e1.setDept("Development");
		e1.setCompany(c);
		
		Employee e2=new Employee();
		e2.setName("Vishnu");
		e2.setSal(35000);
		e2.setJob("Full Stack");
		e2.setDept("Development");
		e2.setCompany(c);
		
		Employee e3=new Employee();
		e3.setName("Hari");
		e3.setSal(60000);
		e3.setJob("Data Analyst");
		e3.setDept("Data Operation");
		e3.setCompany(c);
		
		try {
			et.begin();
			em.persist(e1);
			em.persist(e2);
			em.persist(e3);
			em.persist(c);
			et.commit();
		} catch (Exception e) {
            e.printStackTrace();
            et.rollback();
		}

	}

}
