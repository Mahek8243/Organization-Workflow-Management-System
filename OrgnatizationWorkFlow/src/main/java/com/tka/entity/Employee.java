package com.tka.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee" ,schema="batch631")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String status;
	private String department;
	private String mobileno;
	private String emailid;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@Column(name="updated_date")
	private Date updatedDate;
	private double salary;
	
	@ManyToOne
	@JoinColumn(name = "cid")
	private Country country;
	
	
	public Employee() {
		
		
	}
	


	public Employee(long id, String name, String status, String department, String mobileno, String emailid,
			String createdBy, Date createdDate, String updatedBy, Date updatedDate, double salary, Country country) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.department = department;
		this.mobileno = mobileno;
		this.emailid = emailid;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.salary = salary;
		this.country = country;
	}




	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getMobileno() {
		return mobileno;
	}


	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}


	public String getEmailid() {
		return emailid;
	}


	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public Date getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}




	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", status=" + status + ", department=" + department
				+ ", mobileno=" + mobileno + ", emailid=" + emailid + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", salary=" + salary
				+ ", country=" + country + "]";
	}
	
	

}
