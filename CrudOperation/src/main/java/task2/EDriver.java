package task2;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EDriver {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		System.out.println("Enter Employee ID:");
		int eid=s.nextInt();
		System.out.println("Enter Employee Name:");
		String ename=s.next();
		System.out.println("Enter Employee Designation:");
		String job=s.next();
		System.out.println("Enter Employee age:");
		int age=s.nextInt();
		System.out.println("Enter Employee Salary:");
		double sal=s.nextDouble();
		System.out.println("Enter Employee Phone Number:");
		long phone=s.nextLong();
		
		
		EmployeeDetails ed=new EmployeeDetails();
		
		ed.setEid(eid);
		ed.setEname(ename);
		ed.setJob(job);
		ed.setAge(age);
		ed.setSal(sal);
		ed.setPhone(phone);
		
		
		et.begin();
		em.persist(ed);
		et.commit();
		
		

	}

}
