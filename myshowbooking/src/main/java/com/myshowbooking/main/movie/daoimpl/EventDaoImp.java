package com.myshowbooking.main.movie.daoimpl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.myshowbooking.main.movie.dao.EventDao;
import com.myshowbooking.main.movie.model.EventModel;

@Component
@EnableAsync
@EnableTransactionManagement
@Scope(scopeName = "prototype")
@Transactional
public class EventDaoImp implements EventDao<EventModel> {
	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		Session session = (Session) sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public List<EventModel> getbyeventid(String id) {
		final Session session =getSession();
		TypedQuery<EventModel> query =  session.createQuery("FROM "+EventModel.class.getName()+"Where id="+id, EventModel.class);
		return (List<EventModel>) query.getResultList();
		}

		
	

	@Override
	public List<EventModel> getbyeventname(String name) {
		final Session session = getSession();
		TypedQuery<EventModel> query = session.createQuery("FROM "+EventModel.class.getName()+"Where eventname="+ name, EventModel.class);
		return (List<EventModel>) query.getResultList();
		}

	@Override
	public List<EventModel> getallEvent() {
		final Session session =getSession();
		TypedQuery<EventModel> query = session.createQuery("FROM "+EventModel.class.getName()+"where allevent=", EventModel.class);
		return (List<EventModel>) query.getResultList();
	}

	@Override
	public void insertNewEvent(EventModel model) {
		final Session session =getSession();
		System.out.println("from impl"+model.getEventname());
		session.save(model);
		 session.flush();
	}

	@Override
	public void updateEvent(EventModel model) {
		final Session session =getSession();
		 session.update(model);
		
	}

	@Override
	public void deleteMovieById(String id) {
		final Session session =getSession();
		EventModel model = session.load(EventModel.class, id);
		updateEvent(model);
		
	}

}
