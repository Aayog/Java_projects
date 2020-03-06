package com.myshowbooking.main.movie.service;

import com.myshowbooking.main.movie.model.NowShowingMovieCrud;

public interface NowShowingMoviesCRUDService {
void insertNewMovie(NowShowingMovieCrud model);
	
	void updateMovie(NowShowingMovieCrud model);
	
	void deleteMovieById(String id);

}
