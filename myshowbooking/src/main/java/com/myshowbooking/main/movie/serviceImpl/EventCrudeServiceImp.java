package com.myshowbooking.main.movie.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myshowbooking.main.movie.daoimpl.EventDaoImp;
import com.myshowbooking.main.movie.model.EventModel;
import com.myshowbooking.main.movie.service.EvenCrudeService;

@Component
public class EventCrudeServiceImp implements EvenCrudeService {
	@Autowired
	private EventDaoImp eventDaoImp;

	

	@Override
	public void updatebookingStatus(EventModel model) {
		eventDaoImp.updateEvent(model);
		
	}

	@Override
	public void deleteEventById(String id) {
		eventDaoImp.deleteMovieById(id);
		
	}

	@Override
	public void insertNewEvent(EventModel model) {
		eventDaoImp.insertNewEvent(model);
		
	}

	

}
