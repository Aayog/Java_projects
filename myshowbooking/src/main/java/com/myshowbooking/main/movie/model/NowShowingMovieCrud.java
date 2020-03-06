package com.myshowbooking.main.movie.model;

import javax.persistence.Entity;

import com.myshowbooking.main.user.extramodel.CrudModel;

@Entity
public class NowShowingMovieCrud extends CrudModel {
	
	private String id;
	private String moviename;
	private String star;
	private String like;
	private String country;
	private String directedby;
	private String facebooklink;
	private String youtubelink;
	private String bannerimageurl;
	private String movieimageurl;
	private String bookinglink;
	
	
	public NowShowingMovieCrud() {
		super();
	}
	public NowShowingMovieCrud(String createddate, String createdby, String deleteflag, String updatedate,
			String updateby, String comment, String id, String moviename, String star, String like, String country,
			String directedby, String facebooklink, String youtubelink, String bannerimageurl, String movieimageurl,
			String bookinglink) {
		super(createddate, createdby, deleteflag, updatedate, updateby, comment);
		this.id = id;
		this.moviename = moviename;
		this.star = star;
		this.like = like;
		this.country = country;
		this.directedby = directedby;
		this.facebooklink = facebooklink;
		this.youtubelink = youtubelink;
		this.bannerimageurl = bannerimageurl;
		this.movieimageurl = movieimageurl;
		this.bookinglink = bookinglink;
	}
	public String getBannerimageurl() {
		return bannerimageurl;
	}
	public void setBannerimageurl(String bannerimageurl) {
		this.bannerimageurl = bannerimageurl;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDirectedby() {
		return directedby;
	}
	public void setDirectedby(String directedby) {
		this.directedby = directedby;
	}
	public String getFacebooklink() {
		return facebooklink;
	}
	public void setFacebooklink(String facebooklink) {
		this.facebooklink = facebooklink;
	}
	public String getYoutubelink() {
		return youtubelink;
	}
	public void setYoutubelink(String youtubelink) {
		this.youtubelink = youtubelink;
	}
	public String getMovieimageurl() {
		return movieimageurl;
	}
	public void setMovieimageurl(String movieimageurl) {
		this.movieimageurl = movieimageurl;
	}
	public String getBookinglink() {
		return bookinglink;
	}
	public void setBookinglink(String bookinglink) {
		this.bookinglink = bookinglink;
	}
	
	
}
