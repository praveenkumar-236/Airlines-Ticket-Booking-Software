package com.tgi.springAirlines.Entity;

import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "airlines")
@Entity
public class Airlines {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "flightName")
	private String flightName;
	@Column(name = "boardingfrom")
	private String from;
	@Column(name = "boardingto")
	private String to;
	@Column(name = "className")
	private String className;
	@Column(name = "timings")
	private LocalDateTime timings;
	
	
	public Airlines() {
		
	}
	


	public Airlines(Long id, String flightName, String from, String to, String className, LocalDateTime timings) {
		super();
		this.id = id;
		this.flightName = flightName;
		this.from = from;
		this.to = to;
		this.className = className;
		this.timings = timings;
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


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public LocalDateTime getTimings() {
		return timings;
	}


	public void setTimings(LocalDateTime timings) {
		this.timings = timings;
	}
	



	
	
	
	
	

}
