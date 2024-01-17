package com.dataforge.model;

import java.util.List;

public class SearchCriteria {

	private List<String> course;

	private List<String> status;

	private List<String> mode;

	public SearchCriteria() {

	}

	public SearchCriteria(List<String> course, List<String> status, List<String> mode) {
		super();
		this.course = course;
		this.status = status;
		this.mode = mode;
	}

	public List<String> getCourse() {
		return course;
	}

	public void setCourse(List<String> course) {
		this.course = course;
	}

	public List<String> getStatus() {
		return status;
	}

	public void setStatus(List<String> status) {
		this.status = status;
	}

	public List<String> getMode() {
		return mode;
	}

	public void setMode(List<String> mode) {
		this.mode = mode;
	}

	@Override
	public String toString() {
		return "SearchCriteria [course=" + course + ", status=" + status + ", mode=" + mode + "]";
	}
}
