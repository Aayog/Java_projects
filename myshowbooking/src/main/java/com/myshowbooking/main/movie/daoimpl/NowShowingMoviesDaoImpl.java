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
import com.myshowbooking.main.movie.model.NowShowingMovieCrud;

@Component
@EnableAsync
@EnableTransactionManagement
@Scope(scopeName = "prototype")
@Transactional
public class NowShowingMoviesDaoImpl implements MovieDao<NowShowingMovieCrud> {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		Session session = (Session) sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public List<NowShowingMovieCrud> getAllMovies() {
		final Session session = getSession();
		TypedQuery<NowShowingMovieCrud> query = session.createQuery("FROM " + NowShowingMovieCrud.class.getName(),
				NowShowingMovieCrud.class);
		return (List<NowShowingMovieCrud>) query.getResultList();
	}

	@Override
	public NowShowingMovieCrud getMovieByName(String name) {
		final Session session = getSession();
		return (NowShowingMovieCrud) session.createQuery(
				"FROM " + NowShowingMovieCrud.class.getName() + " WHERE moviename = " + name,
				NowShowingMovieCrud.class);
	}

	@Override
	public List<NowShowingMovieCrud> getMoviesByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NowShowingMovieCrud> getMoviesByStar(String star) {
		final Session session = getSession();
		return (List<NowShowingMovieCrud>) session
				.createQuery("FROM " + NowShowingMovieCrud.class.getName() + " WHERE star = " + star,
						NowShowingMovieCrud.class)
				.getResultList();

	}

	@Override
	public void insertNewMovie(NowShowingMovieCrud model) {
		final Session session = getSession();
		session.save(model);
		session.flush();

	}

	@Override
	public void updateMovie(NowShowingMovieCrud model) {
		final Session session = getSession();
		session.update(model);

	}

	@Override
	public void deleteMovieById(String id) {
		final Session session = getSession();
		NowShowingMovieCrud model = session.load(NowShowingMovieCrud.class, id);
		// model.setDeleteFlag(true);
		updateMovie(model);

	}

}
