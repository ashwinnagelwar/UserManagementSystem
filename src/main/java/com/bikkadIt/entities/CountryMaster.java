package com.bikkadIt.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="COUNTRY_MASTER")
@Entity
public class CountryMaster {
	
	@Column(name="COUNTRY_ID")
	@Id
	private Integer country_id;
	
	@Column(name="COUNTRY_NAME")
	private String country_name;

	@Column(name="COUNTRY_CODE")
	private Integer country_code;

	public Integer getCountry_id() {
		return country_id;
	}

	public void setCountry_id(Integer country_id) {
		this.country_id = country_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public Integer getCountry_code() {
		return country_code;
	}

	public void setCountry_code(Integer country_code) {
		this.country_code = country_code;
	}

	@Override
	public String toString() {
		return "CountryMaster [country_id=" + country_id + ", country_name=" + country_name + ", country_code="
				+ country_code + "]";
	}
	
	
	
	
	

}
