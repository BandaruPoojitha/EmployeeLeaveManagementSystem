package com.example.LeaveManagementSystem.DAOclasses;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LeaveManagementSystem.beanclasses.Login;
import com.example.LeaveManagementSystem.repositories.LoginRepo;

@Service
public class LoginDAO {
	@Autowired
	LoginRepo loginrepo;

	public Login getDetails(Login l) {

		String username = l.getUsername();

		Optional<Login> newl = loginrepo.findById(username);

		return newl.get();

	}
}