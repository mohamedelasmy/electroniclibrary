package com.mohamed.login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
	public String login(HttpServletRequest request) throws NoSuchAlgorithmException {

//		String username = null;
//		
//		String password = null;
		
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
		
		String password1 = getEncryptedPassword(password);
		
		List<User> userList = userDao.getUserByUsernameAndPassword(username, password1);
		
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
	
	public String getEncryptedPassword (String password) throws NoSuchAlgorithmException{
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		
		md.update(password.getBytes());
		
	    byte byteData[] = md.digest();

	    //convert the byte to hex format method 1
	    StringBuffer sb = new StringBuffer();

	    for (int i = 0; i < byteData.length; i++) {

	    	sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));

	    }
		
		return sb.toString();
		
	}
	
}
