package com.tgi.springAirlines.Dto;

import lombok.Data;

@Data
public class ContinentRequestDto {
	
    private Long id;
	private String continentName;
	private String continentShortCode;
}
