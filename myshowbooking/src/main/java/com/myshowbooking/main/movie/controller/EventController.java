package com.myshowbooking.main.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myshowbooking.main.movie.model.EventModel;
import com.myshowbooking.main.movie.service.EvenCrudeService;

@Controller
public class EventController {
	
	@Autowired
	EvenCrudeService eventCrudService;
	
	@RequestMapping("/")
	public String getEventDisplay(Model model) {

		return "index";
	}
	@RequestMapping("/insertevent")
	public String geteventinsert(@ModelAttribute  EventModel eventmovie) {
		eventCrudService.insertNewEvent(eventmovie);

		return "index";
	}
	@RequestMapping("/updateevent")
	public String geteventupdate(@ModelAttribute  EventModel eventmovie) {
		eventCrudService.updatebookingStatus(eventmovie);

		return "index";
	}


}
