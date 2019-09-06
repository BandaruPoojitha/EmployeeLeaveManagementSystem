package com.example.LeaveManagementSystem.DAOclasses;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LeaveManagementSystem.beanclasses.BalanceLeaves;
import com.example.LeaveManagementSystem.beanclasses.Department;
import com.example.LeaveManagementSystem.beanclasses.Employee;
import com.example.LeaveManagementSystem.beanclasses.Login;
import com.example.LeaveManagementSystem.repositories.BalanceRepo;
import com.example.LeaveManagementSystem.repositories.DepartmentRepo;
import com.example.LeaveManagementSystem.repositories.EmpoyleeRepo;
import com.example.LeaveManagementSystem.repositories.LoginRepo;

@Service
public class AdminDAO {
	@Autowired
	DepartmentRepo departmentrepo;
	@Autowired
	EmpoyleeRepo employeerepo;
	@Autowired
	LoginRepo loginrepo;
	@Autowired
	BalanceRepo balancerepo;

	public String addEmployee(Employee employee) {

		// TODO Auto-generated method stub
		Login login = new Login();
		BalanceLeaves balanceleave = new BalanceLeaves();
		login.setEmployeeId(employee);
		login.setEmployeeType("employee");
		login.setUsername(employee.getEmployeeName() + employee.getEmployeeId());
		login.setPassword(employee.getEmployeeId() + employee.getEmployeeName());
		balanceleave.setEmployeeId(employee);
		balanceleave.setLOP(0);
		balanceleave.setPaid(10);
		employeerepo.save(employee);
		loginrepo.save(login);
		balancerepo.save(balanceleave);

		return "added";
	}

	public void addDepartment(Department department) {
		// TODO Auto-generated method stub
		loginrepo.updaterole(department.getManagerId(), "manager");
		departmentrepo.save(department);

	}

	public ArrayList<String> viewDepartment() {
		// TODO Auto-generated method stub
		ArrayList<Department> al = (ArrayList<Department>) departmentrepo.findAll();

		ArrayList<String> arraylist = new ArrayList<String>();
		for (int i = 0; i < al.size(); i++) {
			arraylist.add(al.get(i).getDepartmentId());
			arraylist.add(al.get(i).getManagerId().getEmployeeId());
		}
		return arraylist;
	}

	public void editAddress(String address, String employeeId) {
		// TODO Auto-generated method stub
		employeerepo.editAddress(address, employeeId);
	}

	public void editEmail(String email, String employeeId) {
		// TODO Auto-generated method stub
		employeerepo.editEmail(email, employeeId);
	}

	public void editContact(String contact, String employeeId) {
		// TODO Auto-generated method stub
		employeerepo.editContact(contact, employeeId);
	}

}
