package com.example.LeaveManagementSystem.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.LeaveManagementSystem.beanclasses.Employee;
import com.example.LeaveManagementSystem.beanclasses.Login;

public interface LoginRepo extends CrudRepository<Login, String> {
	@Query("select s from Login s where s.username=:username")
	Login findType(String username);

	@Transactional
	@Modifying
	@Query("update Login l set l.employeeType=:type where l.employeeId=:managerId")
	void updaterole(Employee managerId, String type);

}
