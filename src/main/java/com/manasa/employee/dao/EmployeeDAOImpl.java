package com.manasa.employee.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.manasa.employee.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addEmployee(Employee employee) { 
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(employee);
		logger.info("Employee added successfully, Employee Details="+employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(employee);
		logger.info("Employee updated successfully, Employee Details="+employee);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listEmployees() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee> employeesList = session.createQuery("from Employee where birth_date LIKE '%1961%' AND gender='M'").list();
		for(Employee employee : employeesList){
			logger.info("Employee List::"+employee);
		}
		return employeesList;
	}

	@Override
	public Employee getEmployeeById(long empNo) {
		Session session = this.sessionFactory.getCurrentSession();		
		Employee employee = (Employee) session.load(Employee.class, new Long(empNo));
		logger.info("Employee loaded successfully, Employee details="+employee);
		return employee;
	}

	@Override
	public void removeEmployee(long empNo) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.load(Employee.class, new Long(empNo));
		if(null != employee){
			session.delete(employee);
		}
		logger.info("Employee deleted successfully, Employee details="+employee);
	}

}
