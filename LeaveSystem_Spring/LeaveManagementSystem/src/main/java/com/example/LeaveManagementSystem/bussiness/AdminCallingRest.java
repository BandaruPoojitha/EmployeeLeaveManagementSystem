package com.example.LeaveManagementSystem.bussiness;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.LeaveManagementSystem.RestURL;
import com.example.LeaveManagementSystem.beanclasses.Department;
import com.example.LeaveManagementSystem.beanclasses.Employee;
@Component
public class AdminCallingRest {
	@Autowired
	RestURL restURI;

	public String addemployee(Employee employee) {
		
		String uri = restURI.getURL()+"/adminrest/createemployee";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.postForObject(uri, employee, String.class);
		return result;
	}

	public String addDepartment(Department department) {
		String uri = restURI.getURL()+"/adminrest/adddepartment/" + department.getDepartmentId() + "/"
				+ department.getManagerId().getEmployeeId();
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
		
	}

	@SuppressWarnings("unchecked")
	public ArrayList<String>  viewDepartment() {
		System.out.println(restURI.getURL()+"**");
		String uri = restURI.getURL()+"/adminrest/viewdepartment";
		RestTemplate restTemplate = new RestTemplate();
		 new RestTemplate();
			System.out.println( restTemplate.getForObject(uri, ArrayList.class)+"*********");
		ArrayList<String> result = restTemplate.getForObject(uri, ArrayList.class);
		return result;
	}

	public void editAddress(Employee employee) {
		String uri =restURI.getURL()+"/adminrest/editaddress/" + employee.getAddress() + "/"
				+ employee.getEmployeeId();
		RestTemplate rt = new RestTemplate();
		 rt.getForObject(uri, String.class);
		
	}

	public void editEmail(Employee employee) {
		String uri =restURI.getURL()+"/adminrest/editemail/" + employee.getEmail() + "/"
				+ employee.getEmployeeId();
		RestTemplate rt = new RestTemplate();
		 rt.getForObject(uri, String.class);
		
	}

	public void editPhoneNumber(Employee employee) {
		String uri =restURI.getURL()+"/adminrest/editcontact/" + employee.getPhonenumber() + "/"
				+ employee.getEmployeeId();
		RestTemplate rt = new RestTemplate();
		rt.getForObject(uri, String.class);
		
	}
}
