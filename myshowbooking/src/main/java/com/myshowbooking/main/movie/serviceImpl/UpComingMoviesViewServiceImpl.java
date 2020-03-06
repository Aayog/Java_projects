package com.myshowbooking.main.movie.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myshowbooking.main.movie.daoimpl.UpComingMoviesDaoImpl;
import com.myshowbooking.main.movie.model.UpComingCrudMovies;
import com.myshowbooking.main.movie.service.UpComingMoviesViewService;

@Component
public class UpComingMoviesViewServiceImpl implements UpComingMoviesViewService{
	
	@Autowired
	UpComingMoviesDaoImpl upComingMovieDaoImpl; 
	
	@Override
	public List<UpComingCrudMovies> getAllMovies() {
		return upComingMovieDaoImpl.getAllMovies();
	}

	@Override
	public UpComingCrudMovies getMovieByName(String name) {
		return upComingMovieDaoImpl.getMovieByName(name);
	}

	@Override
	public List<UpComingCrudMovies> getMoviesByDate(String date) {
		return upComingMovieDaoImpl.getMoviesByDate(date);
	}

	@Override
	public List<UpComingCrudMovies> getMoviesByStar(String star) {
		return upComingMovieDaoImpl.getMoviesByStar(star);
	}

}
