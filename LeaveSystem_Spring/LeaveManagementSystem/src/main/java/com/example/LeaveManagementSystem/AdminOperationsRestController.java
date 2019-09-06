package com.example.LeaveManagementSystem;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.LeaveManagementSystem.DAOclasses.AdminDAO;
import com.example.LeaveManagementSystem.beanclasses.Department;
import com.example.LeaveManagementSystem.beanclasses.Employee;

@RestController
@RequestMapping("/adminrest")
public class AdminOperationsRestController {
	@Autowired
	AdminDAO admin;

	@RequestMapping(value = "/createemployee", method = RequestMethod.POST)
	@ResponseBody
	public String employeeCreate(@RequestBody Employee employee) {
		String result = admin.addEmployee(employee);

		return result;
	}

	@RequestMapping(value = "/adddepartment/{dptid}/{mgrid}", method = RequestMethod.GET)
	@ResponseBody
	public String addDepartment(@PathVariable("dptid") String departmentId, @PathVariable("mgrid") String managerId) {
		Department department = new Department();
		department.setDepartmentId(departmentId);
		Employee employee = new Employee();
		employee.setEmployeeId(managerId);
		department.setManagerId(employee);
		admin.addDepartment(department);
		return "added";
	}

	@RequestMapping("/viewdepartment")
	public ArrayList<String> viewDepartment() {
		ArrayList<String> al = admin.viewDepartment();
		return al;
	}

	@RequestMapping("/editaddress/{address}/{empid}")
	public String editAddress(@PathVariable("address") String address, @PathVariable("empid") String employeeId) {
		admin.editAddress(address, employeeId);
		return "editdaddress";
	}

	@RequestMapping("/editemail/{email}/{empid}")
	public String editEmail(@PathVariable("email") String email, @PathVariable("empid") String employeeId) {
		admin.editEmail(email, employeeId);
		return "editedemail";
	}

	@RequestMapping("/editcontact/{contact}/{empid}")
	public String editContact(@PathVariable("contact") String contact, @PathVariable("empid") String employeeId) {
		admin.editContact(contact, employeeId);
		return "editdcontact";
	}
}
