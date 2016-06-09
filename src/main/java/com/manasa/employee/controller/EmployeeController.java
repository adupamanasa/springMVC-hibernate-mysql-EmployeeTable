package com.manasa.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manasa.employee.Employee;
import com.manasa.employee.service.EmployeeService;

@Controller
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired(required=true)
	@Qualifier(value="employeeService")
	public void setPersonService(EmployeeService es){
		this.employeeService = es;
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("listEmployees", this.employeeService.listEmployees());
		return "employee";
	}
	
	//For add and update employee both
	@RequestMapping(value= "/employee/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee employee){
		
		if(employee.getEmpNo() == 0){
			//new employee, add it
			this.employeeService.addEmployee(employee);
		}else{
			//existing employee, call update
			this.employeeService.updateEmployee(employee);
		}
		
		return "redirect:/employees";
		
	}
	
	@RequestMapping("/remove/{empNo}")
    public String removePerson(@PathVariable("empNo") long empNo){
		
        this.employeeService.removeEmployee(empNo);
        return "redirect:/employees";
    }
 
    @RequestMapping("/edit/{empNo}")
    public String editEmployee(@PathVariable("empNo") long empNo, Model model){
        model.addAttribute("employee", this.employeeService.getEmployeeById(empNo));
        model.addAttribute("listEmployees", this.employeeService.listEmployees());
        return "employee";
    }
	
}