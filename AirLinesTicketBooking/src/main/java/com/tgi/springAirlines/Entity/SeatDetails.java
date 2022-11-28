package com.tgi.springAirlines.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SeatDetails {
	@JsonProperty("className")
	private String className;
	@JsonProperty("seatCount")
	private Long seatCount;
	@JsonProperty("bookedSeat")
	private Long bookedSeat;
	@JsonProperty("availableSeat")
	private Long availableSeat;
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Long getSeatCount() {
		return seatCount;
	}
	public void setSeatCount(Long seatCount) {
		this.seatCount = seatCount;
	}
	public Long getBookedSeat() {
		return bookedSeat;
	}
	public void setBookedSeat(Long bookedSeat) {
		this.bookedSeat = bookedSeat;
	}
	public Long getAvailableSeat() {
		return availableSeat;
	}
	public void setAvailableSeat(Long availableSeat) {
		this.availableSeat = availableSeat;
	}
   




}
