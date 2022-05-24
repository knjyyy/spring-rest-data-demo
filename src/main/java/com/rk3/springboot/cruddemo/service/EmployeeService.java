package com.rk3.springboot.cruddemo.service;

import java.util.List;

import com.rk3.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	public Employee findById(int id);
	public Employee save(Employee employee);
	public void deleteById(int id);

}
