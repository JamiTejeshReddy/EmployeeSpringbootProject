package com.amdocs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	private int id;
	private String employeeName;
	private String employeeAddress;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String employeeName, String employeeAddress) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName + ", employeeAddress=" + employeeAddress + "]";
	}

}
