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

@Table(name = "city")
@Entity
@JsonInclude(JsonInclude.Include.ALWAYS)
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "cityName")
	private String cityName;
	@Column(name = "status")
	private boolean status;
	@Column(name = "cityShortCode")
	private String cityShortCode;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "state_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private State state;

	public City() {

	}

	public City(Long id, String cityName, boolean status, String cityShortCode, State state) {
		super();
		this.id = id;
		this.cityName = cityName;
		this.status = status;
		this.cityShortCode = cityShortCode;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getCityShortCode() {
		return cityShortCode;
	}

	public void setCityShortCode(String cityShortCode) {
		this.cityShortCode = cityShortCode;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
