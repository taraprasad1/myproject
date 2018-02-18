package com.rest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDetails {
@Id
	@Column
private String fname;
@Column
private String mname;
@Column
private String lname;
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getMname() {
	return mname;
}
public void setMname(String mname) {
	this.mname = mname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}

}
