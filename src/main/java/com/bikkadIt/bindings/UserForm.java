package com.bikkadIt.bindings;

import java.util.Date;

public class UserForm {
	
	private String first_name;
	
	private String last_name;
	
	private String user_email;
	
	private Long user_phno;
	
	private Date user_DOB;
	
	private String gender;
	
	private String country;
	
	private String state;

	private String city;
	
	
	private Integer countryId;
	
	private Integer stateId;
	
	private Integer cityId;
	
	private String password;
	
	private char AccStatus;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getAccStatus() {
		return AccStatus;
	}

	public void setAccStatus(char accStatus) {
		AccStatus = accStatus;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public Long getUser_phno() {
		return user_phno;
	}

	public void setUser_phno(Long user_phno) {
		this.user_phno = user_phno;
	}

	public Date getUser_DOB() {
		return user_DOB;
	}

	public void setUser_DOB(Date user_DOB) {
		this.user_DOB = user_DOB;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
	
}
