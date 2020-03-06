package com.myshowbooking.main.movie.service;

import com.myshowbooking.main.movie.model.UpComingCrudMovies;

public interface UpComingMoviesCRUDService {

	void insertNewMovie(UpComingCrudMovies model);
	
	void updateMovie(UpComingCrudMovies model);
	
	void deleteMovieById(String id);
}
