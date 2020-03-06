package com.myshowbooking.main;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.myshowbooking.main.movie.controller.MovieController;
import com.myshowbooking.main.movie.model.UpComingCrudMovies;
import com.myshowbooking.main.movie.serviceImpl.UpComingMoviesViewServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {TestContext.class, MyshowbookingApplication.class})
public class MyshowbookingApplicationTests {
	
	
	private MockMvc mockMvc;
	
	@InjectMocks
	MovieController movieController;
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Autowired
	UpComingMoviesViewServiceImpl viewService;
	@Before
	public void setup() throws Exception{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
								.build();
	}
	
	@Test
	public void getIndex() throws Exception{
		mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(view().name("index"))
        .andDo(print());
		
	}
	@Test
	public void getInsert() throws Exception{
		UpComingCrudMovies insertModel=new UpComingCrudMovies("Test", "Test", "2018-06-21", "Test", "Test", "Test", "Test", "2018-06-21", "Test", "Test", "Test", "Test","2018-06-20","Test","0","2018-06-21","2018-06-21","Test");
		mockMvc.perform(post("/insert/upcomingmovies")
	            .param("id",insertModel.getId())
	            .param("moviename",insertModel.getMoviename())
	            .param("releasedate",insertModel.getReleasedate())
	            .param("movieimageurl",insertModel.getMovieimageurl())
	            .param("youtubelink",insertModel.getYoutubelink())
	            .param("facebooklink",insertModel.getFacebooklink())
	            .param("bookingenabled",insertModel.getBookingenabled())
	            .param("bookingavailabledate",insertModel.getBookingavailabledate())
	            .param("star",insertModel.getStar())
	            .param("description",insertModel.getDescription())
	            .param("message",insertModel.getMessage())
	            .param("comments",insertModel.getComments())
	            .param("createdby",insertModel.getCreatedby())
	            .param("createddate",insertModel.getCreateddate())
	            .param("deleteflag",insertModel.getDeleteflag())
	            .param("updatedate",insertModel.getUpdatedate())
	            .param("updateby",insertModel.getUpdateby())
	            .param("comment",insertModel.getComments())
	            .flashAttr("upComingCrudMovies", new UpComingCrudMovies()))
				.andDo(print());	
	}
	
	@Test
	public void getUpdate() throws Exception{
		UpComingCrudMovies updateModel = viewService.getAllMovies().get(1);
		updateModel.setMoviename("Updated");
		updateModel.setStar("Updated");
		mockMvc.perform(post("/update/upcomingmovies")
	            .param("id",updateModel.getId())
	            .param("moviename",updateModel.getMoviename())
	            .param("releasedate",updateModel.getReleasedate())
	            .param("movieimageurl",updateModel.getMovieimageurl())
	            .param("youtubelink",updateModel.getYoutubelink())
	            .param("facebooklink",updateModel.getFacebooklink())
	            .param("bookingenabled",updateModel.getBookingenabled())
	            .param("bookingavailabledate",updateModel.getBookingavailabledate())
	            .param("star",updateModel.getStar())
	            .param("description",updateModel.getDescription())
	            .param("message",updateModel.getMessage())
	            .param("comment",updateModel.getComment())
	            .param("createdby",updateModel.getCreatedby())
	            .param("createddate",updateModel.getCreateddate())
	            .param("deleteflag",updateModel.getDeleteflag())
	            .param("updatedate",updateModel.getUpdatedate())
	            .param("updateby",updateModel.getUpdateby())
	            .param("comments",updateModel.getComments())
	            .flashAttr("upComingCrudMovies", new UpComingCrudMovies()))
				.andDo(print());	
	}
	
	@Test
	public void getDelete() throws Exception{
		String id = viewService.getAllMovies().get(1).getId();
		mockMvc.perform(post("/delete/upcomingmovies")
				.param("id", id)
				.flashAttr("id", new String()));
	}

}
