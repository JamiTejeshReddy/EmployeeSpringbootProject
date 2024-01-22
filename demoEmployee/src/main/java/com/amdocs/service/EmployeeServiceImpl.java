package com.amdocs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.entity.Employee;
import com.amdocs.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo er;

	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		this.er = employeeRepo;
	}

	@Override
	public Employee saveEmployee(Employee employee) {

		return er.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return er.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		Employee existingEmployee = er.findById(employee.getId()).get();
		existingEmployee.setEmployeeName(employee.getEmployeeName());
		existingEmployee.setEmployeeAddress(employee.getEmployeeAddress());

		Employee updatedEmployee = er.save(existingEmployee);
		return updatedEmployee;

	}

	@Override
	public void deleteUser(int id) {
		er.deleteById(id);

	}

	@Override
	public Employee getEmployeeById(int id) {

		java.util.Optional<Employee> optionalemp = er.findById(id);
		return optionalemp.orElse(null);

	}
}
