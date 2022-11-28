package com.tgi.springAirlines.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tgi.springAirlines.Dto.AirportRequestDto;
import com.tgi.springAirlines.Dto.AirportResponseDto;

public interface AirportService {

	List<AirportResponseDto> getAllAirport()throws Exception;

	ResponseEntity<?> createAirport(AirportRequestDto airportRequestDto)throws Exception;

	ResponseEntity<?> getAirportById(Long id)throws Exception;

	ResponseEntity<?> updateAirport(AirportRequestDto airportRequestDto)throws Exception;

}
