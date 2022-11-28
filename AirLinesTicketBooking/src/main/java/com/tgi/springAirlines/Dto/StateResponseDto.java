package com.tgi.springAirlines.Dto;



import lombok.Data;
@Data
public class StateResponseDto {
	private Long id;
    private String stateName;
    private boolean status;
    private String stateShortCode;
    private Long countryId;
    private String countryName;
    private String continentName;
}
