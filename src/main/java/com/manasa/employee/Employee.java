package com.manasa.employee;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="employees")
public class Employee {

	@Id
	@Column(name="emp_no")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_entity_seq_gen")
	//@SequenceGenerator(name = "my_entity_seq_gen", sequenceName="MY_ENTITY_SEQ")
	private long empNo;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="birth_date")
	private Date birthDate;

	@Column(name="first_name")
	private String firstName;

	@Column(name="gender")
	private String gender;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="hire_date")
	private Date hireDate;

	@Column(name="last_name")
	private String lastName;

	public Employee() {
	}
	
	public long getEmpNo() {return this.empNo;}

	public void setEmpNo(long empNo) {this.empNo = empNo;}

	public Date getBirthDate() {return this.birthDate;}

	public void setBirthDate(Date birthDate) {this.birthDate = birthDate;}

	public String getFirstName() {return this.firstName;}

	public void setFirstName(String firstName) { this.firstName = firstName;}

	public String getGender() {return this.gender;}

	public void setGender(String gender) {this.gender = gender;}

	public Date getHireDate() {return this.hireDate;}

	public void setHireDate(Date hireDate) {this.hireDate = hireDate;}

	public String getLastName() {return this.lastName;}

	public void setLastName(String lastName) {this.lastName = lastName;}

	@Override
	public String toString(){
		return "emp_No="+empNo+", First Name="+firstName+", Last Name="+lastName+", Birth Date="+birthDate+", Gender="+gender+", Hire Date="+hireDate;
	}
}