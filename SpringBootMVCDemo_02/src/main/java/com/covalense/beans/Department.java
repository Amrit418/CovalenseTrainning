package com.covalense.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int id ;
private String name ;
private int deptno ;
public Department(int id, String name, int deptno) {
	super();
	this.id = id;
	this.name = name;
	this.deptno = deptno;
}
public Department() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getDeptno() {
	return deptno;
}
public void setDeptno(int deptno) {
	this.deptno = deptno;
}
@Override
public String toString() {
	return "Department [id=" + id + ", name=" + name + ", deptno=" + deptno + "]";
}


}
