
package com.sprk.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Employee {
	
	private int empId;
	private String name;
    private String gender;
    private double salary;
    private Date joiningDate;
    private String email;
    private Timestamp createdAt;
    private Timestamp lastUpdate;
    
	public Employee() {
		super();
	}
	public Employee(String name, String gender, double salary, Date joiningDate, String email) {
		super();
		this.name = name;
		this.gender = gender;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.email = email;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", gender=" + gender + ", salary=" + salary
				+ ", joiningDate=" + joiningDate + ", email=" + email + ", createdAt=" + createdAt + ", lastUpdate="
				+ lastUpdate + "]";
	}
    
	
    

}
