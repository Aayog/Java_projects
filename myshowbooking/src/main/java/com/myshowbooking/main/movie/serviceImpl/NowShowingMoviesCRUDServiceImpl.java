package com.myshowbooking.main.movie.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.myshowbooking.main.movie.daoimpl.NowShowingMoviesDaoImpl;
import com.myshowbooking.main.movie.model.NowShowingMovieCrud;
import com.myshowbooking.main.movie.service.NowShowingMoviesCRUDService;

@Component
public class NowShowingMoviesCRUDServiceImpl implements NowShowingMoviesCRUDService {

	@Autowired
	NowShowingMoviesDaoImpl nowShowingMoviesDaoImpl;

	@Override
	public void insertNewMovie(NowShowingMovieCrud model) {
		nowShowingMoviesDaoImpl.insertNewMovie(model);

	}

	@Override
	public void updateMovie(NowShowingMovieCrud model) {
		nowShowingMoviesDaoImpl.updateMovie(model);
	}

	@Override
	public void deleteMovieById(String id) {
		nowShowingMoviesDaoImpl.deleteMovieById(id);

	}

}
