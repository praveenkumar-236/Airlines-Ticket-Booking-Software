package com.tgi.springAirlines.Dto;

import lombok.Data;

@Data
public class AirportRequestDto {
    private Long airportId;
	private Long cityId;
    private String airportName;
    private String airportShortCode;


}
