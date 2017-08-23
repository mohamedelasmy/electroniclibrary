package com.mohamed.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request) {

//		String username = null;
//		
//		String password = null;
		
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
		
		if(username.equals("mohamed") && password.equals("123456")){
			return "d.jsp";
		}
		else{
			username = "";
			password = "";
			request.setAttribute(username, password);
			return "index.jsp";
			
		}

		
	}
	
}
