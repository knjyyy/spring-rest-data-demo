package com.rk3.springboot.cruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk3.springboot.cruddemo.dao.EmployeeDAO;
import com.rk3.springboot.cruddemo.entity.Employee;
import com.rk3.springboot.cruddemo.rest.EmployeeNotFoundException;
import com.rk3.springboot.cruddemo.service.EmployeeService;

//@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if (employee == null)
			throw new EmployeeNotFoundException("Employee not found with id: " + employeeId);

		return employee;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		return employeeService.save(employee);
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployeeById(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if (employee == null)
			throw new EmployeeNotFoundException("Employee not found with id: " + employeeId);
		
		employeeService.deleteById(employeeId);
		return "Employee deleted with ID: " + employeeId;
	}
}
