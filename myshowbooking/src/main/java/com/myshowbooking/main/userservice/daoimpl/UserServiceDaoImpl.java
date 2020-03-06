package com.myshowbooking.main.userservice.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.myshowbooking.main.user.model.User;
import com.myshowbooking.main.userservice.dao.UserServiceDao;

@Component
@EnableAsync
@EnableTransactionManagement
@Scope(scopeName = "prototype")
@Transactional
public class UserServiceDaoImpl implements UserServiceDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUsername(String username) {
		Session session =sessionFactory.getCurrentSession();
		User user= (User) session.createQuery("FROM " + User.class.getName() + " WHERE USERNAME= :username ")
				.setParameter("username", username).getSingleResult();
		return user;
	}
}
