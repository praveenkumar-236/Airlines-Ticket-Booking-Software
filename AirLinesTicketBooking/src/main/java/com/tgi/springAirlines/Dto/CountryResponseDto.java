package com.tgi.springAirlines.Dto;



import java.util.List;

import com.tgi.springAirlines.Entity.Continent;

import lombok.Data;
@Data
public class CountryResponseDto {
	
	private Long id;
    private String countryName;
    private String countryShortCode;
    private boolean status;
    private String continentName;
    private Long continentId;
    
   
   
    

}
