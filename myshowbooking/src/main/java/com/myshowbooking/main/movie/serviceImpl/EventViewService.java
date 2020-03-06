package com.myshowbooking.main.movie.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myshowbooking.main.movie.daoimpl.EventDaoImp;
import com.myshowbooking.main.movie.model.EventModel;
import com.myshowbooking.main.movie.service.EvenViewService;
@Component

public class EventViewService implements EvenViewService{
	@Autowired
	 private EventDaoImp eventDaoImp;

	@Override
	public List<EventModel> getAllEvents() {
		
		return eventDaoImp.getallEvent();
	}

	@Override
	public List<EventModel> getEventByname(String name) {
		
		return eventDaoImp.getbyeventname(name);
	}

	
	
	

}
