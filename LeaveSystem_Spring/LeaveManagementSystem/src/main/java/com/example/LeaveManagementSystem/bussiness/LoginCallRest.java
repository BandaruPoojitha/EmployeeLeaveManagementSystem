package com.example.LeaveManagementSystem.bussiness;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.LeaveManagementSystem.RestURL;
import com.example.LeaveManagementSystem.beanclasses.Login;
@Component
public class LoginCallRest {
	@Autowired
	RestURL restURI;
	public ArrayList<String> getLoginDetails(Login login) {
	
		String uri = restURI.getURL()+"/valid/login";
		RestTemplate restTemplate = new RestTemplate();
		ModelAndView modelAndView = new ModelAndView("/Login");
		ArrayList<String> result = restTemplate.postForObject(uri, login, ArrayList.class);
		return result;
	}

}
