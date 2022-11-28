package com.tgi.springAirlines.Dto;

import lombok.Data;

@Data
public class CityResposneDto {
    private Long id;
	private String cityName;
	private boolean status;
	private String cityShortCode;
	private Long stateId;
	private String stateName;
	private String countryName;

}
