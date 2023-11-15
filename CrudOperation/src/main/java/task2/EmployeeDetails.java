package task2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeDetails {
	
	@Id
	private int eid;
	private String ename;
	private String job;
	private int age;
	private double sal;
	private long phone;
	
	
	public int getEid() {
		return eid;
	}
	
	
	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public double getSal() {
		return sal;
	}


	public void setSal(double sal) {
		this.sal = sal;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public void setEid(int eid) {
		this.eid = eid;
	}


	@Override
	public String toString() {
		return "EmployeeDetails [eid=" + eid + ", ename=" + ename + ", job=" + job + ", age=" + age + ", sal=" + sal
				+ ", phone=" + phone + "]";
	}
	
	

}
