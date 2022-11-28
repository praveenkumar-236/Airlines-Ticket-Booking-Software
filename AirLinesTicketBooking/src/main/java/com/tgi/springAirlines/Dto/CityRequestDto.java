package com.tgi.springAirlines.Dto;

import lombok.Data;

@Data
public class CityRequestDto {
    private Long cityId;
    private Long stateId;
	private String cityName;
	private String cityShortCode;

}
