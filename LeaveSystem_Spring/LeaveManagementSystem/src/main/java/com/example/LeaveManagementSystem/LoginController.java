package com.example.LeaveManagementSystem;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.LeaveManagementSystem.beanclasses.Bean;
import com.example.LeaveManagementSystem.beanclasses.Login;
import com.example.LeaveManagementSystem.bussiness.LoginCallRest;

@Controller
@RequestMapping("/rest")
public class LoginController {
	@Autowired
	LoginCallRest logincallRest;
	@ResponseBody
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)

	public ModelAndView getUser(HttpSession session, Login login) throws ServletException, IOException {
		ModelAndView modelAndView = null;
		if (!login.getUsername().isEmpty()) {
			if (!login.getPassword().isEmpty()) {
				Bean bean = new Bean();
				ArrayList<String> result =logincallRest.getLoginDetails(login);
//				String uri = restURI.getURL()+"/valid/login";
//				RestTemplate restTemplate = new RestTemplate();
//				modelAndView = new ModelAndView("/Login");
//				ArrayList<String> result = restTemplate.postForObject(uri, l, ArrayList.class);

				if (result.get(0).equals("admin")) {
					modelAndView = new ModelAndView("/admin");
				} else if (result.get(0).equals("employee") || result.get(0).equals("manager") || result.get(0).equals("CEO")) {
					bean.setEmployeeId(result.get(1));
					bean.setEmployeeType(result.get(0));
					modelAndView = new ModelAndView("/employee");
				} else {
					modelAndView = new ModelAndView("Login");
				}
				return modelAndView;
			} else {
				session.setAttribute("password", "nullpassword");
				modelAndView = new ModelAndView("Login");
			}
		} else {
			session.setAttribute("username", "nullusername");
			modelAndView = new ModelAndView("Login");
		}
		return new ModelAndView("Login");
	}

}
