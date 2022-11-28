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

@Table(name = "airport")
@Entity
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Airport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "airportName")
	private String airportName;
	@Column(name = "status")
	private boolean status;
	@Column(name = "airportShortCode")
	private String airportShortCode;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "city_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private City city;

	public Airport() {

	}

	public Airport(Long id, String airportName, boolean status, String airportShortCode, City city) {
		super();
		this.id = id;
		this.airportName = airportName;
		this.status = status;
		this.airportShortCode = airportShortCode;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getAirportShortCode() {
		return airportShortCode;
	}

	public void setAirportShortCode(String airportShortCode) {
		this.airportShortCode = airportShortCode;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
