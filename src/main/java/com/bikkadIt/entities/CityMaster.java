package com.bikkadIt.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="CITY_MASTER")
public class CityMaster {
	
	@Column(name="CITY_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer city_id;
	
	@Column(name="CITY_NAME")
	private String city_name;

	public Integer getCity_id() {
		return city_id;
	}

	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	@Override
	public String toString() {
		return "CityMaster [city_id=" + city_id + ", city_name=" + city_name + "]";
	}
	
	
	

}
