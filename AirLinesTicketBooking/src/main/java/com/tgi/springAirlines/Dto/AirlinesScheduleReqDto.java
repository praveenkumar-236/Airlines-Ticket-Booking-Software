package com.tgi.springAirlines.Dto;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.tgi.springAirlines.Entity.Airport;
import com.tgi.springAirlines.Entity.Flight;
import com.tgi.springAirlines.Entity.SeatDetails;
import com.tgi.springAirlines.Enum.Days;

import lombok.Data;
@Data
public class AirlinesScheduleReqDto {
	private Long id;
	private Long flightId;
	private Long fromAirPortId;
	private Long toAirportId;
	private String departureTime;
	private String arrivalTime;
	private ArrayList<String> days;





	
	
	
	
	

	

}
