package com.tgi.springAirlines.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tgi.springAirlines.Dto.FlightRequestDto;
import com.tgi.springAirlines.Dto.FlightResponseDto;
import com.tgi.springAirlines.Entity.Company;

public interface FlightService {

	List<FlightResponseDto> getAllFlight()throws Exception;

	ResponseEntity<?> createFlight(FlightRequestDto flightRequestDto)throws Exception;

	ResponseEntity<?> getFlightById(Long id)throws Exception;

	ResponseEntity<?> updateFlight(FlightRequestDto flightRequestDto)throws Exception;



}
