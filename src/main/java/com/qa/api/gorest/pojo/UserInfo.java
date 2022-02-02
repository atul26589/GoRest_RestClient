package com.qa.api.gorest.pojo;

public class UserInfo {
	
	private String name;
	private String gender;
	private String email;
	private String status;
	private Links link;
	public UserInfo(String name, String gender, String email, String status,Links link) {
		
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.status = status;
		this.link=link;
	}
	public Links getLink() {
		return link;
	}
	public void setLink(Links link) {
		this.link = link;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}