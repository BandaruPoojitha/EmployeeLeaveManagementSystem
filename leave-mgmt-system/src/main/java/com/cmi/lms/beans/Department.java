package com.cmi.lms.beans;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Department {
@Id
private  String departmentId;
@OneToMany(mappedBy = "department")
private List<Employee> createmployee=new ArrayList<Employee>();

private  String managerId;
public String getDepartmentId() {
	return departmentId;
}
public void setDepartmentId(String departmentId) {
	this.departmentId = departmentId;
}
public String getManagerId() {
	return managerId;
}
public void setManagerId(String managerId) {
	this.managerId = managerId;
}


}
