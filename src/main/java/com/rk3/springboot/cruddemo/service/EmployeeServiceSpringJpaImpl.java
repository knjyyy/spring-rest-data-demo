package com.rk3.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk3.springboot.cruddemo.dao.EmployeeRepository;
import com.rk3.springboot.cruddemo.entity.Employee;
import com.rk3.springboot.cruddemo.rest.EmployeeNotFoundException;

//@Service
public class EmployeeServiceSpringJpaImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		
		if(!result.isPresent())
			throw new EmployeeNotFoundException("Employee not found with id: " + id);

		return result.get();
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

}
