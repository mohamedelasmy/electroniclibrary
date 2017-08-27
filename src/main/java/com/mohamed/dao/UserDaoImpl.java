package com.mohamed.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mohamed.model.User;

public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	public void save(User user) {
		
		Session session = this.sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.persist(user);
		
		tx.commit();
		
		session.close();
	}

	@SuppressWarnings("unchecked")	
	public List<User> getUserByUsernameAndPassword(String username, String password) {
		
		Session session = this.sessionFactory.openSession();

		List<User> userList = (List<User>) session.createQuery("from User where username = :username")
				.setParameter("username", username)
				.list();

		session.close();
		
		return userList;
	}
	
	

}
