package com.rk3.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rk3.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	@Autowired
	EntityManager entityManager;

	@Override
	public List<Employee> findAll() {
		Query query = entityManager.createQuery("from Employee e");
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee findbyId(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	public Employee save(Employee employee) {
		Employee emp = entityManager.merge(employee);
		employee.setId(emp.getId());
		return employee;
	}

	@Override
	public void deleteById(int id) {
		Query query = entityManager.createQuery("delete from Employee e where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
	}

}
