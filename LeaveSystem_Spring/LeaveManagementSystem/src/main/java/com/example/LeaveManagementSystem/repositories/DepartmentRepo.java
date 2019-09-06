package com.example.LeaveManagementSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LeaveManagementSystem.beanclasses.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, String> {

}
