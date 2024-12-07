package com.noyon.main.Student;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int sId;
public Student(int sId, String sAge, String sName) {
	super();
	this.sId = sId;
	this.sAge = sAge;
	this.sName = sName;
}
public int getsId() {
	return sId;
}
public void setsId(int sId) {
	this.sId = sId;
}
private String sAge;
private String sName;
public String getsName() {
	return sName;
}
public void setsName(String sName) {
	this.sName = sName;
}
public String getsAge() {
	return sAge;
}
public void setsAge(String sAge) {
	this.sAge = sAge;
}
public Student(String sName, String sAge) {
	super();
	this.sName = sName;
	this.sAge = sAge;
}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
  
  
}
