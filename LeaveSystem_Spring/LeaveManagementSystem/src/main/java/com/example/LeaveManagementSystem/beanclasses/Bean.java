package com.example.LeaveManagementSystem.beanclasses;

public class Bean {
	private static String employeeId;
	private static String employeeType;

	public String getEmployeeId() {
		return employeeId;
	}

	public static String getEmployeeType() {
		return employeeType;
	}

	public static void setEmployeeType(String employeeType) {
		Bean.employeeType = employeeType;
	}

	public void setEmployeeId(String employeeId) {
		Bean.employeeId = employeeId;
	}

}
