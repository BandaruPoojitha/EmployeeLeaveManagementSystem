package com.cmi.lms.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmi.lms.beans.ApplyLeave;
import com.cmi.lms.beans.BalanceLeaves;
import com.cmi.lms.service.EmployeeCallingRest;
import com.cmi.lms.util.ApplicationUtil;

@Controller
@RequestMapping("/employee")
public class Employee {
	@Autowired
	EmployeeCallingRest employeecallingRest;
	@RequestMapping(value = "applyleave", method = RequestMethod.GET)
	public String createEmployee() {
		return "redirect:/applyleave.jsp";
	}

	@RequestMapping(value = "grantleave", method = RequestMethod.GET)
	public String grantEmployee(HttpSession session) {
		String empid=(String) session.getAttribute("empid");
		try {
	ArrayList<ApplyLeave> arraylist=employeecallingRest.grantLeave(empid);
		session.setAttribute("list", arraylist);
		return "redirect:/grantleave.jsp";
		}catch(Exception e) {
			return "redirect:/grantleave.jsp";
		}
	}

	@RequestMapping(value = "cancelleave", method = RequestMethod.GET)
	public ModelAndView cancel(HttpSession session) {
		ApplicationUtil au=new ApplicationUtil();
		String empid=(String) session.getAttribute("empid");
		ModelAndView model = new ModelAndView("cancelleave");
		try {
		ArrayList<ApplyLeave> arraylist2=au.cancelLeave(employeecallingRest.cancelLeave(empid));
		model.addObject("cancel", arraylist2);
		return model;
	}catch(Exception e) {
		return model;
	}
	}

	@RequestMapping(value = "track", method = RequestMethod.GET)
	public ModelAndView trackLeave(HttpSession session) {
		String empid=(String) session.getAttribute("empid");
		ModelAndView model = new ModelAndView("trackLeave");
try {
		ArrayList<ApplyLeave> arraylist =employeecallingRest.trackLeave(empid);
		model.addObject("track", arraylist);
		return model;
}catch(Exception e) {
	return new ModelAndView("trackLeave");
}
	}

	@RequestMapping(value = "/balanceleaves", method = RequestMethod.GET)
	public ModelAndView balanceLeaves(HttpSession session) {
		String empid=(String) session.getAttribute("empid");
		ModelAndView model = new ModelAndView("balanceleaves");
try {
		ArrayList<BalanceLeaves> arraylist =employeecallingRest.balanceLeaves(empid);
		model.addObject("balance", arraylist);
		return model;
	}catch(Exception e) {
		return model;
	}
	}
}
