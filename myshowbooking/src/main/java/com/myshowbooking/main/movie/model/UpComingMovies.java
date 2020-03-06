package com.myshowbooking.main.movie.model;

public class UpComingMovies {
	
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
	
	
	public UpComingMovies(String id, String moviename, String releasedate, String movieimageurl, String bannerimageurl, String youtubelink,
			String facebooklink, String bookingenabled, String bookingavailabledate, String star, String description,
			String message, String comments) {
		super();
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
		this.bannerimageurl =bannerimageurl;
	}
	public UpComingMovies() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UpCommingMovies [id=" + id + ", moviename=" + moviename + ", releasedate=" + releasedate
				+ ", movieimageurl=" + movieimageurl + ", youtubelink=" + youtubelink + ", facebooklink=" + facebooklink
				+ ", bookingenabled=" + bookingenabled + ", bookingavailabledate=" + bookingavailabledate + ", star="
				+ star + ", description=" + description + ", message=" + message + ", comments=" + comments + "]";
	}
	
}
