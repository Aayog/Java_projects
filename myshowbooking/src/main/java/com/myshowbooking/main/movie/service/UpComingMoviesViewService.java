package com.myshowbooking.main.movie.service;

import java.util.List;

import com.myshowbooking.main.movie.model.UpComingCrudMovies;

public interface UpComingMoviesViewService {
	List<UpComingCrudMovies> getAllMovies();
	
	UpComingCrudMovies getMovieByName(String name);
	
	List<UpComingCrudMovies> getMoviesByDate(String date);
	
	List<UpComingCrudMovies> getMoviesByStar(String star);
	
}
