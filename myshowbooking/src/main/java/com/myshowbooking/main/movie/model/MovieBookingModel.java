package com.myshowbooking.main.movie.model;

public class MovieBookingModel {
	
	private String id;
	private String movieid;
	private String bookingdate;
	private String userid;
	private String bookingexpiredate;
	private String paymentmethod;
	private String paymentstatus;
	private String currency;
	private String giftvoucher;
	private String offer;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMovieid() {
		return movieid;
	}
	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}
	public String getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getBookingexpiredate() {
		return bookingexpiredate;
	}
	public void setBookingexpiredate(String bookingexpiredate) {
		this.bookingexpiredate = bookingexpiredate;
	}
	public String getPaymentmethod() {
		return paymentmethod;
	}
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	public String getPaymentstatus() {
		return paymentstatus;
	}
	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getGiftvoucher() {
		return giftvoucher;
	}
	public void setGiftvoucher(String giftvoucher) {
		this.giftvoucher = giftvoucher;
	}
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}
	
}
