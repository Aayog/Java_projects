package com.myshowbooking.main.movie.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myshowbooking.main.movie.daoimpl.UpComingMoviesDaoImpl;
import com.myshowbooking.main.movie.model.UpComingCrudMovies;
import com.myshowbooking.main.movie.service.UpComingMoviesCRUDService;

@Component
public class UpComingMoviesCRUDServiceImpl implements UpComingMoviesCRUDService {

	@Autowired
	UpComingMoviesDaoImpl upComingMovieDaoImpl;
	
	@Override
	public void insertNewMovie(UpComingCrudMovies model) {
		upComingMovieDaoImpl.insertNewMovie(model);
	}

	@Override
	public void deleteMovieById(String id) {
		upComingMovieDaoImpl.deleteMovieById(id);
	}

	@Override
	public void updateMovie(UpComingCrudMovies model) {
		upComingMovieDaoImpl.updateMovie(model);
		
	}

}
