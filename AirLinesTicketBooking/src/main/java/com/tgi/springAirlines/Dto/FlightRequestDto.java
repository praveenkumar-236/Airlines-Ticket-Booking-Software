package com.tgi.springAirlines.Dto;

import java.util.List;

import com.tgi.springAirlines.Entity.Company;
import com.tgi.springAirlines.Entity.SeatDetails;
import com.tgi.springAirlines.Enum.FlightType;

import lombok.Data;

@Data
public class FlightRequestDto {
    private Long id;
    private FlightType flightType;
    private List<SeatDetails> seats;
	private String flightName;
    private String description;
    private Long companyId;

 
}
