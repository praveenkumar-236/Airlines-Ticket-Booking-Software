package com.tgi.springAirlines.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tgi.springAirlines.Dto.AirportRequestDto;
import com.tgi.springAirlines.Dto.AirportResponseDto;
import com.tgi.springAirlines.Service.AirportService;

@RestController
@RequestMapping("/airport")
public class AirportController {
	@Autowired
	AirportService airportService;
	
	@RequestMapping(value="/getAllAirport",method = RequestMethod.GET)
	public List<AirportResponseDto>getAllAirport()throws Exception{
		return airportService.getAllAirport();
	}
	@RequestMapping(value="/createAirport",method = RequestMethod.POST)
	public ResponseEntity<?>createAirport(@RequestBody AirportRequestDto airportRequestDto)throws Exception{
		return airportService.createAirport(airportRequestDto);
	}
	@RequestMapping(value="/getCityById{id}",method = RequestMethod.GET)
	public ResponseEntity<?>getAirportById(@PathVariable("id")Long id)throws Exception{
		return airportService.getAirportById(id);
	}
	@RequestMapping(value="/updateAirport",method = RequestMethod.PUT)
	public ResponseEntity<?>updateAirport(@RequestBody AirportRequestDto airportRequestDto)throws Exception{
		return airportService.updateAirport(airportRequestDto);
	}
	

}
