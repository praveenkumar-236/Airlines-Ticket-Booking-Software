package com.tgi.springAirlines.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "state")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "stateName")
	private String stateName;
	@Column(name = "status")
	private boolean status;
	@Column(name = "stateShortCode")
	private String stateShortCode;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "country_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Country country;

	public State() {

	}

	public State(Long id, String stateName, boolean status, String stateShortCode, Country country) {
		super();
		this.id = id;
		this.stateName = stateName;
		this.status = status;
		this.stateShortCode = stateShortCode;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getStateShortCode() {
		return stateShortCode;
	}

	public void setStateShortCode(String stateShortCode) {
		this.stateShortCode = stateShortCode;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}



}
