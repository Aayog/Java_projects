package com.myshowbooking.main.movie.service;

import java.util.List;

import com.myshowbooking.main.movie.model.NowShowingMovieCrud;

public interface NowShowingMoviesViewService {
	List<NowShowingMovieCrud> getAllMovies();

	NowShowingMovieCrud getMovieByName(String name);

	List<NowShowingMovieCrud> getMoviesByDate(String date);

	List<NowShowingMovieCrud> getMoviesByStar(String star);
}
