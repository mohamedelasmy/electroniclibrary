package com.mohamed.login;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mohamed.dao.UserDao;
import com.mohamed.model.User;

@Controller
public class LoginController {

	@Autowired
	private UserDao userDao;
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request) {

//		String username = null;
//		
//		String password = null;
		
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
		
		List<User> userList = userDao.getUserByUsernameAndPassword(username, password);
		
		if(userList != null){
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
