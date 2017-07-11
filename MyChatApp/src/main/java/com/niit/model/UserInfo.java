package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Table(name="UserInfo", schema="COLLABRATIONDB")
@Entity
public class UserInfo 
{   @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userid;
	@Column(unique = true)
	@Pattern(regexp = ".+@.+\\..+", message = "Wrong email!")
	private String email;
	@Size(min = 5, max = 10, message = "Your name should be between 5 - 10 characters.")
	private String username;
	@NotNull(message = "Please select a password")
	@Length(min = 5, max = 10, message = "Password should be between 5 - 10 charactes")
	private String password;
	@Size(min = 10, message = "You cannot entered lessthan 10 digits.")
	private String mobileno;
	private String role;
	private boolean isactive;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	
	
	

}

