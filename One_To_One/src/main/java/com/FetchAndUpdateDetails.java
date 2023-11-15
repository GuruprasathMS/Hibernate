package com;

import java.util.List;


import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class FetchAndUpdateDetails {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("guru");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		System.out.println("Enter the choice: \n1.To Fetch the Person Details \n2.To Fetch all the Details "
				+ "\n3.To fetch the details by Name or by Mobile No \n4.Add or Update or Delete the details" );
		int choice=s.nextInt();
		switch (choice) {
		case 1:
		{
			System.out.println("Enter the Id:");
			int id=s.nextInt();
			Person p=em.find(Person.class, id);
			
			System.out.println(p);
            
		}
			
			break;
		case 2:
		{
			
			Query q=em.createQuery("select p from Person p ");
			List<Person> l=q.getResultList();
			for (Person p1 : l) {
				System.out.println(p1);
				
			}
			
		}
		    break;
		case 3:
		{
			System.out.println("Enter Option: \n1.Fetch by Name \n2.Fetch by Mobile No");
			int opt=s.nextInt();
			switch(opt)
			{
			case 1:
			{
				System.out.println("Enter the Name:");
				String name=s.next();
				Query q=em.createQuery("select p from Person p where p.name=?5");
				q.setParameter(5, name);
				
				Person p=(Person) q.getSingleResult();
				
				System.out.println(p);
			}
			break;
			case 2:
			{
				System.out.println("Enter the Mobile Number:");
				long mobile=s.nextLong();
				Query q=em.createQuery("select p from Person p where p.mobile=:mobile");
				q.setParameter("mobile", mobile);
				Person p=(Person) q.getSingleResult();
				System.out.println(p.getC());
				
			}
			break;
			}
		}
		break;
		case 4:
		{
			System.out.println("Enter the task: \n1.Add details \n2.Update details \n3.Delete details");
			int t=s.nextInt();
			switch(t)
			{
			case 1:
			{
				System.out.println("Enter Id:");
				int id=s.nextInt();
				System.out.println("Enter Name:");
				String name=s.next();
				System.out.println("Enter Gender:");
				String gender=s.next();
				System.out.println("Enter Age:");
				int age=s.nextInt();
				System.out.println("Enter Mobile:");
				long mobile=s.nextLong();
				
				Person p=new Person();
				p.setId(id);
				p.setName(name);
				p.setGender(gender);
				p.setAge(age);
				p.setMobile(mobile);
				
				
				
				System.out.println("Enter Aadhar No:");
				int ano=s.nextInt();
				System.out.println("Enter DOB:");
				String DOB=s.next();
				System.out.println("Enter Address:");
				String address=s.next();
				
				AadharCard c=new AadharCard();
				c.setAno(ano);
				c.setDOB(DOB);
				c.setAddress(address);
				p.setC(c);
				
				try {
					et.begin();
					em.persist(p);
					em.persist(c);
					et.commit();
				} catch (Exception e) {
					et.rollback();
				}
			}
			break;
			case 2:
			{
				System.out.println("Enter Id: ");
				int id=s.nextInt();
				Person p=em.find(Person.class, id);
				
				System.out.println("Update the Mobile No:");
				long mobile=s.nextLong();
				p.setMobile(mobile);
				
				et.begin();
				em.merge(p);
				et.commit();
				
				System.out.println("Updated");
			}
			break;
			case 3:
			{
				System.out.println("Enter Id: ");
				int id=s.nextInt();
				System.out.println("Enter the Aadhar No");
				int ano=s.nextInt();
				Person p=em.find(Person.class, id);
				
//				AadharCard c=em.find(AadharCard.class, ano);
//				et.begin();
//				em.remove(c);
//				et.commit();
				
				if (p!=null) {
					
					AadharCard c=p.getC();
					et.begin();
					em.remove(p);
					em.remove(c);
					et.commit();
					
					System.out.println("Deleted");
				} else {
					et.rollback();
					System.out.println("ID not found");

				}
				
			}
			}
		}
		break;
		default:
		{
			System.out.println("Invalid Input");
		}
			break;
		}
		
		

	}

}
