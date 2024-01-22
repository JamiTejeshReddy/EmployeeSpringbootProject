package com.amdocs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.entity.Employee;
import com.amdocs.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employees")
public class MyEmployeeController {

	@Autowired
	EmployeeServiceImpl employeeServiceImpl;

	@PostMapping("/add")
	public String add(@RequestBody Employee employee) {
		employeeServiceImpl.saveEmployee(employee);
		return "Employee Added Successfully";
	}

	@GetMapping("/getAll")
	public List<Employee> getAllEmployees() {

		return employeeServiceImpl.getAllEmployees();
	}

	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int userId, @RequestBody Employee user) {

		user.setId(userId);
		Employee updatedEmployee = employeeServiceImpl.updateEmployee(user);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int userId) {
		employeeServiceImpl.deleteUser(userId);
		return new ResponseEntity<>("Employee successfully deleted!", HttpStatus.OK);

	}

	@GetMapping("/find/{id}")
	public Employee findEmployee(@PathVariable("id") int employeeId) {

		Employee employee = employeeServiceImpl.getEmployeeById(employeeId);
		return employee;
	}

}
