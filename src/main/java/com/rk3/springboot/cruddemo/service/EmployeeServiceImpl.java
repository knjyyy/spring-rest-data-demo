package com.rk3.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rk3.springboot.cruddemo.dao.EmployeeDAO;
import com.rk3.springboot.cruddemo.entity.Employee;

//@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	@Qualifier("employeeDAOJpaImpl")
	private EmployeeDAO employeeDAO;

	@Transactional
	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Transactional
	@Override
	public Employee findById(int id) {
		return employeeDAO.findbyId(id);
	}

	@Transactional
	@Override
	public Employee save(Employee employee) {
		return employeeDAO.save(employee);
	}

	@Transactional
	@Override
	public void deleteById(int id) {
		employeeDAO.deleteById(id);
	}

}
