package com.example.main.services;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.main.model.StudentModel;

@Component
@EnableAsync
@EnableTransactionManagement
@Scope(scopeName = "prototype")
@Transactional
public class StudentService {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public StudentModel findUserByEmailAddress(String fname) {
		try {
			final Session session = sessionFactory.getCurrentSession();
			return (StudentModel) session
					.createQuery(
							"FROM "
									+ StudentModel.class.getName()
									+ " u_s WHERE u_s.fname = :fname ")
					.setParameter("fname", fname).uniqueResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	public StudentModel store(StudentModel user) {
		final Session session = sessionFactory.getCurrentSession();
		System.out.println(session.isConnected());
		System.out.println(session.getDelegate());
		System.out.println(session.getTenantIdentifier());
		System.out.println(session.isOpen());
		session.save(user);
		session.flush();
		session.clear();
		return user;
	}

}
