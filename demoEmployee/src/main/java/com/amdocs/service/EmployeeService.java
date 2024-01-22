package com.amdocs.service;

import java.util.List;

import com.amdocs.entity.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee updateEmployee(Employee user);

	public void deleteUser(int id);

	public Employee getEmployeeById(int id);

}
