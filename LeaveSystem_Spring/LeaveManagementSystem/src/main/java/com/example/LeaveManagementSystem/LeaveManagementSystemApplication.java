package com.example.LeaveManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.LeaveManagementSystem.DAOclasses","com.example.LeaveManagementSystem.bussiness","com.example.LeaveManagementSystem"})
//@EnableJpaRepositories(basePackages = {"com.example.LeaveManagementSystem.repositories"})
//@EntityScan(basePackages = {"com.example.LeaveManagementSystem.beanclasses"})
public class LeaveManagementSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(LeaveManagementSystemApplication.class, args);
	}

}
