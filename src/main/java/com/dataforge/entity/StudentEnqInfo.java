package com.dataforge.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentEnqInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer enqid;
	private String studentname;
	private String studentphno;
	private String studentmode;
	private String studentcourse;
	private String studentstatus;
	@CreationTimestamp
	private LocalDate currentDate;
	private Integer cid;

	public StudentEnqInfo() {

	}

	public StudentEnqInfo(Integer enqid, String studentname, String studentphno, String studentmode,
			String studentcourse, String studentstatus, LocalDate currentDate, Integer cid) {
		super();
		this.enqid = enqid;
		this.studentname = studentname;
		this.studentphno = studentphno;
		this.studentmode = studentmode;
		this.studentcourse = studentcourse;
		this.studentstatus = studentstatus;
		this.currentDate = currentDate;
		this.cid = cid;
	}

	public Integer getEnqid() {
		return enqid;
	}

	public void setEnqid(Integer enqid) {
		this.enqid = enqid;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentphno() {
		return studentphno;
	}

	public void setStudentphno(String studentphno) {
		this.studentphno = studentphno;
	}

	public String getStudentmode() {
		return studentmode;
	}

	public void setStudentmode(String studentmode) {
		this.studentmode = studentmode;
	}

	public String getStudentcourse() {
		return studentcourse;
	}

	public void setStudentcourse(String studentcourse) {
		this.studentcourse = studentcourse;
	}

	public String getStudentstatus() {
		return studentstatus;
	}

	public void setStudentstatus(String studentstatus) {
		this.studentstatus = studentstatus;
	}

	public LocalDate getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(LocalDate currentDate) {
		this.currentDate = currentDate;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "StudentEnqInfo [enqid=" + enqid + ", studentname=" + studentname + ", studentphno=" + studentphno
				+ ", studentmode=" + studentmode + ", studentcourse=" + studentcourse + ", studentstatus="
				+ studentstatus + ", currentDate=" + currentDate + ", cid=" + cid + "]";
	}
}
