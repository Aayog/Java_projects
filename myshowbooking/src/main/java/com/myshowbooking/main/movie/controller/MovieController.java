package com.myshowbooking.main.movie.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myshowbooking.main.movie.model.NowShowingMovieCrud;
import com.myshowbooking.main.movie.model.UpComingCrudMovies;
import com.myshowbooking.main.movie.service.NowShowingMoviesCRUDService;
import com.myshowbooking.main.movie.service.NowShowingMoviesViewService;
import com.myshowbooking.main.movie.service.UpComingMoviesCRUDService;
import com.myshowbooking.main.movie.service.UpComingMoviesViewService;

@Controller
public class MovieController {
	@Autowired
	UpComingMoviesCRUDService upComingMoviesCRUDService;

	@Autowired
	UpComingMoviesViewService upComingMoviesViewService;

	@Autowired
	NowShowingMoviesCRUDService nowShowingMoviesCRUDService;

	@Autowired
	NowShowingMoviesViewService nowShowingMoviesViewService;


//	@RequestMapping("/login")
//	public String getlogin() {
//		return "login";
//	}

	@RequestMapping("/")
	public String getIndex(HttpServletRequest request, Model model,@AuthenticationPrincipal Principal principal) {
		//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		List<UpComingCrudMovies> upComingCrudMovies = upComingMoviesViewService.getAllMovies();
		model.addAttribute("upComingMovie", upComingCrudMovies);
		List<NowShowingMovieCrud> nowShowingMovieCrud = nowShowingMoviesViewService.getAllMovies();
		model.addAttribute("nowShowingMovie", nowShowingMovieCrud);
		return "test";
	}



	/*@RequestMapping("/display")
	public String getDisplay(Model model) {

		return "display";
	}*/

	@RequestMapping("/insertupcoming")
	public String insertMovie(@ModelAttribute UpComingCrudMovies insertModel ) {
		upComingMoviesCRUDService.insertNewMovie(insertModel);
		System.out.println("Success");
		return "redirect:/display";
	}


	@RequestMapping("/insertnowshowing")
	public String insertMovie(@ModelAttribute NowShowingMovieCrud insertModel1 ) {
		nowShowingMoviesCRUDService.insertNewMovie(insertModel1);
		System.out.println("Success");
		return "redirect:/display";
	}

	@RequestMapping("/updateupcoming")
	public String updateMovie(@ModelAttribute UpComingCrudMovies updateModel) {
		upComingMoviesCRUDService.updateMovie(updateModel);
		System.out.println("Success");

		return "redirect:/display";
	}

	@RequestMapping("/updatenowshowing")
	public String updateMovie(@ModelAttribute NowShowingMovieCrud updateModel1) {
		nowShowingMoviesCRUDService.insertNewMovie(updateModel1);
		System.out.println("Success");

		return "redirect:/display";
	}

	@RequestMapping("/delete")
	public String deleteMovie(@ModelAttribute String id) {
		upComingMoviesCRUDService.deleteMovieById(id);
		nowShowingMoviesCRUDService.deleteMovieById(id);
		System.out.println("Success");
		return "redirect:/display";
	}



}
