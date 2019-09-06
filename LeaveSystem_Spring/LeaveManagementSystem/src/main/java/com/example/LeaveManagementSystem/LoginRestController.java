package com.example.LeaveManagementSystem;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.LeaveManagementSystem.DAOclasses.LoginDAO;
import com.example.LeaveManagementSystem.beanclasses.Login;

@RestController
@RequestMapping("/valid")
public class LoginRestController {
	@Autowired
	LoginDAO ls;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<String> loginMethod(@RequestBody Login l) {
		Login login = ls.getDetails(l);

		ArrayList<String> arrayList = new ArrayList<>();
		if (login.getEmployeeType().equals("admin")) {
			arrayList.add(login.getEmployeeType());

		}

		else {
			arrayList.add(login.getEmployeeType());
			arrayList.add(login.getEmployeeId().getEmployeeId());
		}
		return arrayList;
	}
}
