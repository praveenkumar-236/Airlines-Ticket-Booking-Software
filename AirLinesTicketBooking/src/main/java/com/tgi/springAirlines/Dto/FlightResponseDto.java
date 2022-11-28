package com.tgi.springAirlines.Dto;

import java.util.List;

import com.tgi.springAirlines.Entity.Company;
import com.tgi.springAirlines.Entity.SeatDetails;
import com.tgi.springAirlines.Enum.FlightType;

import lombok.Data;

@Data
public class FlightResponseDto {
	private Long id;
	private String flightName;
	private FlightType flightType;
	private List<SeatDetails> seats;
    private String description;
	private boolean status;
	private String companyName;

}
