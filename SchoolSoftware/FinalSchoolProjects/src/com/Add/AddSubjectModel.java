package com.Add;

public class AddSubjectModel {
//	EXAM_ID,CLASS,SUBJECT,THEORY_FM,THEORY_PM,PRACTICAL_FM,PRACTICAL_PM
	private String exam_name;
	private int _class;
	private String subject;
	private int theory_FM;
	private int theory_PM;
	private int practical_FM;
	private int pracitacal_PM;
	
	public AddSubjectModel(String exam_name, int _class, String subject, int theory_FM, int theory_PM, int practical_FM,
			int pracitacal_PM) {
		super();
		this.exam_name = exam_name;
		this._class = _class;
		this.subject = subject;
		this.theory_FM = theory_FM;
		this.theory_PM = theory_PM;
		this.practical_FM = practical_FM;
		this.pracitacal_PM = pracitacal_PM;
	}
	
	public AddSubjectModel() {
		super();
	}
	public String getExam_name() {
		return exam_name;
	}
	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}
	public int get_class() {
		return _class;
	}
	public void set_class(int _class) {
		this._class = _class;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getTheory_FM() {
		return theory_FM;
	}
	public void setTheory_FM(int theory_FM) {
		this.theory_FM = theory_FM;
	}
	public int getTheory_PM() {
		return theory_PM;
	}
	public void setTheory_PM(int theory_PM) {
		this.theory_PM = theory_PM;
	}
	public int getPractical_FM() {
		return practical_FM;
	}
	public void setPractical_FM(int practical_FM) {
		this.practical_FM = practical_FM;
	}
	public int getPracitacal_PM() {
		return pracitacal_PM;
	}
	public void setPracitacal_PM(int pracitacal_PM) {
		this.pracitacal_PM = pracitacal_PM;
	}
	
	
	
}
