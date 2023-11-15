package com;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AadharCard {
	
	@Id
	private int ano;
	private String DOB;
	private String address;
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "AadharCard [ano=" + ano + ", DOB=" + DOB + ", address=" + address + "]";
	}
	
	
	
	
	

}
