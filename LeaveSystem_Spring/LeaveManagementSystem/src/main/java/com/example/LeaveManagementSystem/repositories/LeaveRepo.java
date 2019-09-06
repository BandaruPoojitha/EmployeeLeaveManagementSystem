package com.example.LeaveManagementSystem.repositories;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.LeaveManagementSystem.beanclasses.ApplyLeave;
import com.example.LeaveManagementSystem.beanclasses.Employee;

@Repository
public interface LeaveRepo extends CrudRepository<ApplyLeave, Integer> {
	@Query("select a from ApplyLeave a where a.applyTo=:employeeId and a.status=:status")
	ArrayList<ApplyLeave> findLeaves(Employee employeeId, String status);

	@Transactional
	@Modifying
	@Query("update ApplyLeave a set a.applyTo=:managerId where a.sno=:sno")
	void updateManager(int sno, Employee managerId);

	@Transactional
	@Modifying
	@Query("update ApplyLeave a set a.status=:status where a.sno=:sno")
	void updateStatus(String status, int sno);

	@Query("select a from ApplyLeave a where a.employeeId=:employeeId")
	ArrayList<ApplyLeave> trackLeaveDetails(Employee employeeId);

	@Transactional
	@Modifying
	@Query("delete from ApplyLeave a where a.sno=:sno")
	void cancelLeave(int sno);

	@Query("SELECT e FROM ApplyLeave e WHERE e.employeeId.employeeId=:employee and e.enddate=:enddate ")
	ArrayList<ApplyLeave> validLeaves(@Param("enddate") Date enddate, @Param("employee") String employee);

	@Query("select e from ApplyLeave e where (MONTH(e.enddate)=:enddate) and (MONTH(e.startdate)=:startdate) and (e.LeaveType=:type) and (e.employeeId=:employee) and e.status<>:status")
	ArrayList<ApplyLeave> validLOP(int startdate, int enddate, Employee employee, String type,String status);
	
	@Query("SELECT e FROM ApplyLeave e WHERE e.employeeId.employeeId=:employee and e.startdate=:startdate ")
	ArrayList<ApplyLeave> validLeavesEnd(@Param("startdate")Date startdate, @Param("employee") String employeeId);
	@Query("SELECT e FROM ApplyLeave e WHERE e.employeeId.employeeId=:employeeId and e.startdate=:startdate and e.enddate=:enddate")
	ArrayList<ApplyLeave> sameDates(Date startdate, Date enddate, String employeeId);
}
