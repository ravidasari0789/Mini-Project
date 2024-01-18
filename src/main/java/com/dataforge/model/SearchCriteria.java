package com.dataforge.model;

import java.util.List;

public class SearchCriteria {

	private List<String> studentstatus;

	private List<String> studentcourse;

	private List<String> studentmode;

	public SearchCriteria() {

	}

	public SearchCriteria(List<String> studentstatus, List<String> studentcourse, List<String> studentmode) {
		super();
		this.studentstatus = studentstatus;
		this.studentcourse = studentcourse;
		this.studentmode = studentmode;
	}

	public List<String> getStudentstatus() {
		return studentstatus;
	}

	public void setStudentstatus(List<String> studentstatus) {
		this.studentstatus = studentstatus;
	}

	public List<String> getStudentcourse() {
		return studentcourse;
	}

	public void setStudentcourse(List<String> studentcourse) {
		this.studentcourse = studentcourse;
	}

	public List<String> getStudentmode() {
		return studentmode;
	}

	public void setStudentmode(List<String> studentmode) {
		this.studentmode = studentmode;
	}
}
