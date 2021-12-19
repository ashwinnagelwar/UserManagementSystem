package com.bikkadIt.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Table(name="USER_ACCOUNT")
@Entity
public class UserAccount {
	
	@Column(name="USER_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer user_id;
	@Column(name="FIRST_NAME")
	private String first_name;
	@Column(name="LAST_NAME")
	private String last_name;
	@Column(name="USER_EMAIL")
	private String useremail;
	@Column(name="USER_PASSWORD")
	private String password;
	@Column(name="USER_PHNO")
	private Long user_phno;
	@Column(name="USER_DOB")
	private Date user_DOB;
	@Column(name="USER_GENDER")
	private String gender;
	@Column(name="USER_COUNTRY")
	private String country;
	@Column(name="USER_STATE")
	private String state;
	@Column(name="USER_CITY")
	private String city;
	@Column(name="ACTIVE_SW")
	private char active_sw;
	@Column(name="COUNTRY_ID")
	private Integer countryId;
	@Column(name="STATE_ID")
	private Integer stateId;
	@Column(name="CITY_ID")
	private Integer cityId;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
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
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public char getActive_sw() {
		return active_sw;
	}
	public void setActive_sw(char active_sw) {
		this.active_sw = active_sw;
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
		return "UserAccount [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", user_email=" + useremail + ", password=" + password + ", user_phno=" + user_phno + ", user_DOB="
				+ user_DOB + ", gender=" + gender + ", country=" + country + ", state=" + state + ", city=" + city
				+ ", active_sw=" + active_sw + ", countryId=" + countryId + ", stateId=" + stateId + ", cityId="
				+ cityId + "]";
	}
	
	
	@Column(name="CREATEDDATE", updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name="UPDATEDDATE", insertable = false)
	@UpdateTimestamp
	private LocalDate updatedDate;
	
	
	
	
	
	
	

}
