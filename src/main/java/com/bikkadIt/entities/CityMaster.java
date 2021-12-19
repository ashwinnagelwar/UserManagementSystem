package com.bikkadIt.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="CITY_MASTER")
@Entity
public class CityMaster {
	
	@Column(name="CITY_ID")
	@Id
	private Integer city_id;
	
	@Column(name="CITY_NAME")
	private String city_name;
	
	@Column(name="STATE_ID")
	private Integer stateId;

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

	
	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "CityMaster [city_id=" + city_id + ", city_name=" + city_name + ", state_id=" + stateId + "]";
	}
	
	
	
	

}
