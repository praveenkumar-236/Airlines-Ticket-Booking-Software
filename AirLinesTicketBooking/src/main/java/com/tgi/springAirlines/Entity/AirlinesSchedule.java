package com.tgi.springAirlines.Entity;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import com.tgi.springAirlines.Enum.Days;
import com.vladmihalcea.hibernate.type.json.JsonBlobType;

@Table(name = "AirlinesSchedule")
@Entity
@JsonInclude(JsonInclude.Include.ALWAYS)
@TypeDef(name = "jsonb", typeClass = JsonBlobType.class)
public class AirlinesSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "status")
	private boolean status;
	@Column(name = "arrivalTime")
	private LocalTime arrivalTime;
	@Column(name = "departureTime")
	private LocalTime departureTime;
	@Column(name = "flightName")
	private String flightName;
	@Column(name = "frommAirport")
	private String frommAirport;
	@Column(name = "frommAirportShortCode")
	private String frommAirportShortCode;
	@Column(name = "tooAirport")
	private String tooAirport;
	@Column(name = "tooAirportShortCode")
	private String tooAirportShortCode;
	@Column(name = "seats")
	@Type(type = "jsonb")
	private List<SeatDetails> seats;

	@Column(name = "days")
	private ArrayList<String> days;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FromAirport", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Airport from;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ToAirport", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Airport to;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Flight_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Flight flight;

	public AirlinesSchedule() {

	}

	public AirlinesSchedule(Long id, boolean status, LocalTime arrivalTime, LocalTime departureTime, String flightName,
			String frommAirport, String frommAirportShortCode, String tooAirport, String tooAirportShortCode,
			List<SeatDetails> seats, ArrayList<String> days, Airport from, Airport to, Flight flight) {
		super();
		this.id = id;
		this.status = status;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.flightName = flightName;
		this.frommAirport = frommAirport;
		this.frommAirportShortCode = frommAirportShortCode;
		this.tooAirport = tooAirport;
		this.tooAirportShortCode = tooAirportShortCode;
		this.seats = seats;
		this.days = days;
		this.from = from;
		this.to = to;
		this.flight = flight;
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

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFrommAirport() {
		return frommAirport;
	}

	public void setFrommAirport(String frommAirport) {
		this.frommAirport = frommAirport;
	}

	public String getFrommAirportShortCode() {
		return frommAirportShortCode;
	}

	public void setFrommAirportShortCode(String frommAirportShortCode) {
		this.frommAirportShortCode = frommAirportShortCode;
	}

	public String getTooAirport() {
		return tooAirport;
	}

	public void setTooAirport(String tooAirport) {
		this.tooAirport = tooAirport;
	}

	public String getTooAirportShortCode() {
		return tooAirportShortCode;
	}

	public void setTooAirportShortCode(String tooAirportShortCode) {
		this.tooAirportShortCode = tooAirportShortCode;
	}

	public List<SeatDetails> getSeats() {
		return seats;
	}

	public void setSeats(List<SeatDetails> seats) {
		this.seats = seats;
	}

	public ArrayList<String> getDays() {
		return days;
	}

	public void setDays(ArrayList<String> days) {
		this.days = days;
	}

	public Airport getFrom() {
		return from;
	}

	public void setFrom(Airport from) {
		this.from = from;
	}

	public Airport getTo() {
		return to;
	}

	public void setTo(Airport to) {
		this.to = to;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}
