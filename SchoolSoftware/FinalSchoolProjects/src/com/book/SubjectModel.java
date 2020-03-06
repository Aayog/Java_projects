package com.book;

public class SubjectModel {
	private int subject_ID;
	private String subject_Name;
	private int _class;
	
	
	public SubjectModel(int subject_ID, String subject_Name, int _class) {
		super();
		this.subject_ID = subject_ID;
		this.subject_Name = subject_Name;
		this._class = _class;
	}
	public SubjectModel(String subject_Name, int _class) {
		super();
		this.subject_Name = subject_Name;
		this._class = _class;
	}
	
	public int getSubject_ID() {
		return subject_ID;
	}
	public void setSubject_ID(int subject_ID) {
		this.subject_ID = subject_ID;
	}
	public String getSubject_Name() {
		return subject_Name;
	}
	public void setSubject_Name(String subject_Name) {
		this.subject_Name = subject_Name;
	}
	public int get_class() {
		return _class;
	}
	public void set_class(int _class) {
		this._class = _class;
	}
	
	

}
