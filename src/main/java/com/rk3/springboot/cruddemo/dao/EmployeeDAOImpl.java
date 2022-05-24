package com.rk3.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rk3.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	EntityManager entityManager;

	@Override
	@Transactional
	public List<Employee> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<Employee> query = session.createQuery("from Employee e", Employee.class);
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public Employee findbyId(int id) {
		Session session = entityManager.unwrap(Session.class);
		Employee employee = session.get(Employee.class, id);
		
		return employee;
	}

	@Override
	public Employee save(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
		return employee;
	}

	@Override
	public void deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("delete from Employee e where id=:idEmployee");
		query.setParameter("idEmployee", id);
		query.executeUpdate();
	}

}
