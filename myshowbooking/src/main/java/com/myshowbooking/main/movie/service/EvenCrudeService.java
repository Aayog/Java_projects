package com.myshowbooking.main.movie.service;

import com.myshowbooking.main.movie.model.EventModel;

public interface EvenCrudeService {
	void insertNewEvent(EventModel model);

	void updatebookingStatus(EventModel model);

	void deleteEventById(String id);

}
