package com.tgi.springAirlines.Dto;


import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.tgi.springAirlines.Entity.Airport;
import com.tgi.springAirlines.Entity.SeatDetails;
import com.tgi.springAirlines.Enum.Days;

import lombok.Data;
@Data
public class AirlinesScheduleResDto {
	private Long id;
	private Long flightId;
	private Long fromAirPortId;
	private Long toAirportId;
	private boolean status;
	private String flightName;
	private List<SeatDetails> seats;
	private String fromAirport;
	private String toAirport;
	private LocalTime departureTime;
	private LocalTime arrivalTime;
	private ArrayList<String> days;
	
}
