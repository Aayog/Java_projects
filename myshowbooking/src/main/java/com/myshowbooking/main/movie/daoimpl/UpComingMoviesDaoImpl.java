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

import com.myshowbooking.main.movie.dao.MovieDao;
import com.myshowbooking.main.movie.model.UpComingCrudMovies;


@Component
@EnableAsync
@EnableTransactionManagement
@Scope(scopeName = "prototype")
@Transactional
public class UpComingMoviesDaoImpl implements MovieDao<UpComingCrudMovies> {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		final Session session = (Session) sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public List<UpComingCrudMovies> getAllMovies() {
		final Session session =getSession();
		TypedQuery<UpComingCrudMovies> query = session.createQuery("FROM "+UpComingCrudMovies.class.getName(), UpComingCrudMovies.class);
		return (List<UpComingCrudMovies>) query.getResultList();
	}


	@Override
	public void insertNewMovie(UpComingCrudMovies model) {
		final Session session =getSession();
		session.save(model);
	}

	@Override
	public void deleteMovieById(String id) {
		final Session session =getSession();
		UpComingCrudMovies model = session.load(UpComingCrudMovies.class, id);
		//model.setDeleteFlag(true);
		updateMovie(model);
	}

	@Override
	public void updateMovie(UpComingCrudMovies model) {
		final Session session =getSession();
		session.update(model);
	}

	@Override
	public UpComingCrudMovies getMovieByName(String name) {
		final Session session =getSession();
		return (UpComingCrudMovies) session.createQuery("FROM "+UpComingCrudMovies.class.getName()+ " WHERE moviename = "+name,UpComingCrudMovies.class);
	}

	@Override
	public List<UpComingCrudMovies> getMoviesByDate(String date) {
		final Session session =getSession();
		return (List<UpComingCrudMovies>) session.createQuery("FROM "+UpComingCrudMovies.class.getName()+ " WHERE releasedate = "+date,UpComingCrudMovies.class).getResultList();
	}
	
	@Override
	public List<UpComingCrudMovies> getMoviesByStar(String star) {
		final Session session =getSession();
		return (List<UpComingCrudMovies>) session.createQuery("FROM "+UpComingCrudMovies.class.getName()+ " WHERE star = "+star,UpComingCrudMovies.class).getResultList();
	}

	
}
