package com.rk3.springboot.cruddemo.dao;

import java.util.List;

import com.rk3.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();
	public Employee findbyId(int id);
	public Employee save(Employee employee);
	public void deleteById(int id);
}
