package com.dataforge.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Counsellors_Info")
public class CounsellorsInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer cid;
	private String name;
	private String email;
	private String pwd;
	private String phno;

	public CounsellorsInfo() {

	}

	public CounsellorsInfo(Integer cid, String name, String email, String pwd, String phno) {
		super();
		this.cid = cid;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.phno = phno;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	@Override
	public String toString() {
		return "Counsellors_Info [cid=" + cid + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", phno="
				+ phno + "]";
	}
}
