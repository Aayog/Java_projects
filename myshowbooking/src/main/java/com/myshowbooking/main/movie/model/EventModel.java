package com.myshowbooking.main.movie.model;

public class EventModel {
	private String eventid;
	private String eventname;
	private String organizedby;
	private String eventdate;
	private String bookingOpenStatus;
	private String ticketPrice;
	private String location;
	private String guest;
	private String imageUrl;
	private String contact;
	private String duration;
	private String timeFrom;
	
	
	
	
	public EventModel(String eventid, String eventname, String organizedby, String eventdate, String bookingOpenStatus,
			String ticketPrice, String location, String guest, String imageUrl, String contact, String duration,
			String timeFrom) {
		super();
		this.eventid = eventid;
		this.eventname = eventname;
		this.organizedby = organizedby;
		this.eventdate = eventdate;
		this.bookingOpenStatus = bookingOpenStatus;
		this.ticketPrice = ticketPrice;
		this.location = location;
		this.guest = guest;
		this.imageUrl = imageUrl;
		this.contact = contact;
		this.duration = duration;
		this.timeFrom = timeFrom;
	}
	public EventModel() {
		// TODO Auto-generated constructor stub
	}
	public String getEventid() {
		return eventid;
	}
	public void setEventid(String eventid) {
		this.eventid = eventid;
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public String getOrganizedby() {
		return organizedby;
	}
	public void setOrganizedby(String organizedby) {
		this.organizedby = organizedby;
	}
	public String getEventdate() {
		return eventdate;
	}
	public void setEventdate(String eventdate) {
		this.eventdate = eventdate;
	}
	public String getBookingOpenStatus() {
		return bookingOpenStatus;
	}
	public void setBookingOpenStatus(String bookingOpenStatus) {
		this.bookingOpenStatus = bookingOpenStatus;
	}
	public String getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGuest() {
		return guest;
	}
	public void setGuest(String guest) {
		this.guest = guest;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getTimeFrom() {
		return timeFrom;
	}
	public void setTimeFrom(String timeFrom) {
		this.timeFrom = timeFrom;
	}
	

}
