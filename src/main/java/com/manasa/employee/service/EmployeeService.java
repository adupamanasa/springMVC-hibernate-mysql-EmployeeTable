package com.manasa.employee.service;

import java.util.List;

import com.manasa.employee.Employee;

public interface EmployeeService {
	
	public void addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public List<Employee> listEmployees();
	public Employee getEmployeeById(long empNo);
	public void removeEmployee(long empNo);

}
