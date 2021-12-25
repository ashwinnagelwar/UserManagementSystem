package com.bikkadIt.bindings;

import java.util.Date;

public class UserForm {
	
	private String first_name;
	
	private String last_name;
	
	private String userEmail;
	
	private Long user_phno;
	
	private Date user_DOB;
	
	private String gender;
	
	private Integer countryId;
	
	private Integer stateId;
	
	private Integer cityId;
	
	private String password;
	
	private String active_sw;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActive_sw() {
		return active_sw;
	}

	public void setActive_sw(String active_sw) {
		this.active_sw = active_sw;
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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

	@Override
	public String toString() {
		return "UserForm [first_name=" + first_name + ", last_name=" + last_name + ", user_email=" + userEmail
				+ ", user_phno=" + user_phno + ", user_DOB=" + user_DOB + ", gender=" + gender + ", countryId="
				+ countryId + ", stateId=" + stateId + ", cityId=" + cityId + ", password=" + password + ", AccStatus="
				+ active_sw + "]";
	}
	
	
	
}
