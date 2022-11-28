package com.tgi.springAirlines.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "continent")
public class Continent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "status")
	private boolean status;
	@Column(name = "continentShortCode")
	private String continentShortCode;
	@Column(name = "continentName")
	private String continentName;

	public Continent() {

	}

	public Continent(Long id, boolean status, String continentShortCode, String continentName) {
		super();
		this.id = id;
		this.status = status;
		this.continentShortCode = continentShortCode;
		this.continentName = continentName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getContinentShortCode() {
		return continentShortCode;
	}

	public void setContinentShortCode(String continentShortCode) {
		this.continentShortCode = continentShortCode;
	}

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

}
