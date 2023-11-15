package task2;



import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class FetchAll {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		
		Query q=em.createQuery("select ed from EmployeeDetails ed");
		
		List<EmployeeDetails> ed=q.getResultList();
		
		for (EmployeeDetails ed1 : ed) {
			
			System.out.println(ed1);
		}
		
				

	}

}
