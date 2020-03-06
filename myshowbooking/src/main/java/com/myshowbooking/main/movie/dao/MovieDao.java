package com.myshowbooking.main.movie.dao;

import java.util.List;

public interface MovieDao<E> {
	
	List<E> getAllMovies();
	
	E getMovieByName(String name);
	
	List<E> getMoviesByDate(String date);
	
	List<E> getMoviesByStar(String star);
	
	
	void insertNewMovie(E model);
	
	void updateMovie(E model);
	
	void deleteMovieById(String id);

}
