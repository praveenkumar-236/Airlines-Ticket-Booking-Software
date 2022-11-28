package com.tgi.springAirlines.Dto;

import com.tgi.springAirlines.Entity.Continent;

import lombok.Data;

@Data
public class CountryRequestDto {
	private Long countryId;
    private Long continentId;
    private String countryName;
    private String countryShortCode;
	

}
