package com.myshowbooking.main.movie.service;

import java.util.List;

import com.myshowbooking.main.movie.model.EventModel;

;

public interface EvenViewService {
	List<EventModel> getAllEvents();

	List<EventModel> getEventByname(String name);
	

}
