package com.dataforge.model;



public class SearchCriteria {

	private String studentstatus;

	private String studentcourse;

	private String studentmode;

	public SearchCriteria() {

	}

	public SearchCriteria(String studentstatus, String studentcourse, String studentmode) {
		super();
		this.studentstatus = studentstatus;
		this.studentcourse = studentcourse;
		this.studentmode = studentmode;
	}

	public String getStudentstatus() {
		return studentstatus;
	}

	public void setStudentstatus(String studentstatus) {
		this.studentstatus = studentstatus;
	}

	public String getStudentcourse() {
		return studentcourse;
	}

	public void setStudentcourse(String studentcourse) {
		this.studentcourse = studentcourse;
	}

	public String getStudentmode() {
		return studentmode;
	}

	public void setStudentmode(String studentmode) {
		this.studentmode = studentmode;
	}

}
