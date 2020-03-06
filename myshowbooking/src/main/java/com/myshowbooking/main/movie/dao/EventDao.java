package com.myshowbooking.main.movie.dao;

import java.util.List;

public interface EventDao<EventModel> {
	List<EventModel> getbyeventid(String id);

	List<EventModel> getbyeventname(String name );

	List<EventModel> getallEvent();

	void insertNewEvent(EventModel model);

	void updateEvent(EventModel model);

	void deleteMovieById(String id);

}
