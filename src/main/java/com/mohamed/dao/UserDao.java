package com.mohamed.dao;

import java.util.List;

import com.mohamed.model.User;

public interface UserDao {
	
	public void save(User user);
	
	public List<User> getUserByUsernameAndPassword(String username,String password);

}
