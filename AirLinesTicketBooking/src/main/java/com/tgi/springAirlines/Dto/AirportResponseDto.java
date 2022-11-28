package com.tgi.springAirlines.Dto;

import com.tgi.springAirlines.Entity.State;

import lombok.Data;

@Data
public class AirportResponseDto {
	private Long id;
    private String airportName;
    private boolean status;
    private String airportShortCode;
    private String cityName;
    private Long cityId;
    private String stateName;
    private String countryName;

}
