package com.tgi.springAirlines.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tgi.springAirlines.Enum.FlightType;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import com.vladmihalcea.hibernate.type.json.JsonBlobType;

@Table(name = "flight")
@Entity
@JsonInclude(JsonInclude.Include.ALWAYS)
@TypeDef(name = "jsonb", typeClass = JsonBlobType.class)
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "flightName")
	private String flightName;
	@Column(name = "description")
	private String description;
	@Column(name = "status")
	private boolean status;
	@Column(name = "seats")
	@Type(type = "jsonb")
	private List<SeatDetails> seats;

	@Enumerated(EnumType.STRING)
	@Column(name = "flightType")
	private FlightType flightType;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Company_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Company company;

	public Flight() {

	}

	public Flight(Long id, String flightName, String description, boolean status, List<SeatDetails> seats,
			FlightType flightType, Company company) {
		super();
		this.id = id;
		this.flightName = flightName;
		this.description = description;
		this.status = status;
		this.seats = seats;
		this.flightType = flightType;
		this.company = company;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<SeatDetails> getSeats() {
		return seats;
	}

	public void setSeats(List<SeatDetails> seats) {
		this.seats = seats;
	}

	public FlightType getFlightType() {
		return flightType;
	}

	public void setFlightType(FlightType flightType) {
		this.flightType = flightType;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
