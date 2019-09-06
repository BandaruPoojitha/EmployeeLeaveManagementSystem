package com.example.LeaveManagementSystem.bussiness;

import java.util.Date;

public class DaysCount {
	public static long daysBetween(Date one, Date two) {
		long difference = (one.getTime() - two.getTime()) / 86400000;
		return Math.abs(difference);
	}
}
