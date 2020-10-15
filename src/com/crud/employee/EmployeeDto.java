package com.crud.employee;

import java.io.Serializable;

public class EmployeeDto implements Serializable {
private int eno;
private String name;
private String mno;
private String  email, pwd, gender;
private float salary;
public int getEno() {
	return eno;
}
public void setEno(int eno) {
	this.eno = eno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMno() {
	return mno;
}
public void setMno(String mno) {
	this.mno = mno;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}

public EmployeeDto() {
	
}
public EmployeeDto(String name, String mno, String email, String pwd, String gender, float salary) {
	
	this.name = name;
	this.mno = mno;
	this.email = email;
	this.pwd = pwd;
	this.gender = gender;
	this.salary = salary;
}


}
