package com.mohamed.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mohamed.model.User;

@Repository
public interface UserDao {
	
	public void save(User user);
	
	public List<User> getUserByUsernameAndPassword(String username,String password);

}
