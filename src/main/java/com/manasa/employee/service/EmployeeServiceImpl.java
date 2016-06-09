package com.manasa.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manasa.employee.dao.EmployeeDAO;
import com.manasa.employee.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

		private EmployeeDAO employeeDAO;

		public void setEmployeeDAO(EmployeeDAO employeeDAO) {
			this.employeeDAO = employeeDAO;
		}

		@Override
		@Transactional
		public void addEmployee(Employee employee) {
			this.employeeDAO.addEmployee(employee);
		}

		@Override
		@Transactional
		public void updateEmployee(Employee employee) {
			this.employeeDAO.updateEmployee(employee);
		}

		@Override
		@Transactional
		public List<Employee> listEmployees() {
		 return this.employeeDAO.listEmployees();
		}

		@Override
		@Transactional
		public Employee getEmployeeById(long empNo) {
			return this.employeeDAO.getEmployeeById(empNo);
		}

		@Override
		@Transactional
		public void removeEmployee(long empNo) {
			this.employeeDAO.removeEmployee(empNo);
		}

	}
