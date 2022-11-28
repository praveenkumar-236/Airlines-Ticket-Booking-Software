package com.tgi.springAirlines.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tgi.springAirlines.Dto.CountryRequestDto;
import com.tgi.springAirlines.Dto.CountryResponseDto;
import com.tgi.springAirlines.Service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {
	@Autowired
	CountryService countryService;
	@RequestMapping(value="/getAllCountry",method = RequestMethod.GET)
	public List<CountryResponseDto>getAllCountry()throws Exception{
		return countryService.getAllCountry();
	}
	@RequestMapping(value="/createCountry",method = RequestMethod.POST)
	public ResponseEntity<?>createCountry(@RequestBody CountryRequestDto countryRequestDto )throws Exception{
		return countryService.createCountry(countryRequestDto);
	}
	@RequestMapping(value="/getCountryById{id}",method = RequestMethod.GET)
	public ResponseEntity<?>getCountryById(@PathVariable("id")Long id)throws Exception{
		return countryService.getCountryById(id); 
	}
	@RequestMapping(value="/updateCountry",method = RequestMethod.PUT)
	public ResponseEntity<?>updateCountry(@RequestBody CountryRequestDto countryRequestDto)throws Exception{
		return countryService.updateCountry(countryRequestDto);
	}

	
	
	
	

}
