package com.myshowbooking.main.movie.model;

import javax.persistence.Entity;

import com.myshowbooking.main.user.extramodel.CrudModel;

@Entity
public class UpComingCrudMovies extends CrudModel {
	
	private String id;
	private String moviename;
	private String releasedate;
	private String movieimageurl;
	private String bannerimageurl;
	private String youtubelink;
	private String facebooklink;
	private String bookingenabled;
	private String bookingavailabledate;
	private String star;
	private String description;
	private String message;
	private String comments;
	
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
	public String getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}
	public String getMovieimageurl() {
		return movieimageurl;
	}
	public void setMovieimageurl(String movieimageurl) {
		this.movieimageurl = movieimageurl;
	}
	public String getYoutubelink() {
		return youtubelink;
	}
	public void setYoutubelink(String youtubelink) {
		this.youtubelink = youtubelink;
	}
	public String getFacebooklink() {
		return facebooklink;
	}
	public void setFacebooklink(String facebooklink) {
		this.facebooklink = facebooklink;
	}
	public String getBookingenabled() {
		return bookingenabled;
	}
	public void setBookingenabled(String bookingenabled) {
		this.bookingenabled = bookingenabled;
	}
	public String getBookingavailabledate() {
		return bookingavailabledate;
	}
	public void setBookingavailabledate(String bookingavailabledate) {
		this.bookingavailabledate = bookingavailabledate;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "UpComingCrudMovies [id=" + id + ", moviename=" + moviename + ", releasedate=" + releasedate
				+ ", movieimageurl=" + movieimageurl + ", youtubelink=" + youtubelink + ", facebooklink=" + facebooklink
				+ ", bookingenabled=" + bookingenabled + ", bookingavailabledate=" + bookingavailabledate + ", star="
				+ star + ", description=" + description + ", message=" + message + ", comments=" + comments + "]";
	}
	public UpComingCrudMovies(String id, String moviename, String releasedate, String movieimageurl,
			String youtubelink, String facebooklink, String bookingenabled, String bookingavailabledate, String star,
			String description, String message, String comments,String createddate, String createdby, String deleteflag, String updatedate, String updateby,
			String comment) {
		super(createddate, createdby, deleteflag, updatedate, updateby, comment);
		this.id = id;
		this.moviename = moviename;
		this.releasedate = releasedate;
		this.movieimageurl = movieimageurl;
		this.youtubelink = youtubelink;
		this.facebooklink = facebooklink;
		this.bookingenabled = bookingenabled;
		this.bookingavailabledate = bookingavailabledate;
		this.star = star;
		this.description = description;
		this.message = message;
		this.comments = comments;
	}
	public UpComingCrudMovies() {
		super();
	}
	
	
}
