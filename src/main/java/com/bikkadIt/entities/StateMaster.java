package com.bikkadIt.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="STATE_MASTER")
@Entity
public class StateMaster {

	@Column(name="STATE_ID")
	@Id
	private Integer state_id;
	
	@Column(name="STATE_NAME")
	private String state_name;
	
	@Column(name="COUNTRY_ID")
	private Integer countryId;

	public Integer getState_id() {
		return state_id;
	}

	public void setState_id(Integer state_id) {
		this.state_id = state_id;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "StateMaster [state_id=" + state_id + ", state_name=" + state_name + ", countryId=" + countryId + "]";
	}

	
	
	
}
