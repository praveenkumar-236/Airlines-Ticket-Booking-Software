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
@Table(name = "country")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "countryName")
	private String countryName;
	@Column(name = "status")
	private boolean status;
	@Column(name = "countryShortCode")
	private String countryShortCode;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Continent_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Continent continent;

	public Country() {

	}

	public Country(Long id, String countryName, boolean status, String countryShortCode, Continent continent) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.status = status;
		this.countryShortCode = countryShortCode;
		this.continent = continent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getCountryShortCode() {
		return countryShortCode;
	}

	public void setCountryShortCode(String countryShortCode) {
		this.countryShortCode = countryShortCode;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

}
