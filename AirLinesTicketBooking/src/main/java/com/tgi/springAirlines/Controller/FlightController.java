package com.tgi.springAirlines.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tgi.springAirlines.Dto.FlightRequestDto;
import com.tgi.springAirlines.Dto.FlightResponseDto;
import com.tgi.springAirlines.Service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {
	@Autowired
	FlightService flightService;
	@RequestMapping(value="/getAllFlight",method = RequestMethod.GET)
	public List<FlightResponseDto>getAllFlight()throws Exception{
		return flightService.getAllFlight();
	}
	@RequestMapping(value="/createFlight",method = RequestMethod.POST)
	public ResponseEntity<?>createFlight(@RequestBody FlightRequestDto flightRequestDto )throws Exception{
		return flightService.createFlight(flightRequestDto);
	}
	@RequestMapping(value="/getFlightById{id}",method = RequestMethod.GET)
	public ResponseEntity<?>getFlightById(@PathVariable("id")Long id)throws Exception{
		return flightService.getFlightById(id); 
	}
	@RequestMapping(value="/updateCountry",method = RequestMethod.PUT)
	public ResponseEntity<?>updateFlight(@RequestBody FlightRequestDto flightRequestDto)throws Exception{
		return flightService.updateFlight(flightRequestDto);
	}

}
