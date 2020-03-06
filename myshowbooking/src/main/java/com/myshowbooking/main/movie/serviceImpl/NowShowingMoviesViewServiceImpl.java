package com.myshowbooking.main.movie.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myshowbooking.main.movie.daoimpl.NowShowingMoviesDaoImpl;
import com.myshowbooking.main.movie.model.NowShowingMovieCrud;
import com.myshowbooking.main.movie.service.NowShowingMoviesViewService;
@Component
public class NowShowingMoviesViewServiceImpl implements NowShowingMoviesViewService {
	
	@Autowired
	NowShowingMoviesDaoImpl nowShowingMoviesDaoImpl;

	@Override
	public List<NowShowingMovieCrud> getAllMovies() {
		
		return nowShowingMoviesDaoImpl.getAllMovies();
	}

	@Override
	public NowShowingMovieCrud getMovieByName(String name) {
		
		return nowShowingMoviesDaoImpl.getMovieByName(name);
	}

	@Override
	public List<NowShowingMovieCrud> getMoviesByDate(String date) {
		return null;
	}

	@Override
	public List<NowShowingMovieCrud> getMoviesByStar(String star) {
		
		return nowShowingMoviesDaoImpl.getMoviesByStar(star);
	}

}
