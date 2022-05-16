package com.sp.model;

public class UserDto {

	private String name="jd";
	private String password;
	private String surname;
	
	
	public UserDto(String name, String password, String surname) {
		this.name = name;
		this.password = password;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	
}
