package com.tgi.springAirlines.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.tgi.springAirlines.Dto.FlightRequestDto;
import com.tgi.springAirlines.Dto.FlightResponseDto;
import com.tgi.springAirlines.Entity.Company;
import com.tgi.springAirlines.Entity.Flight;

import com.tgi.springAirlines.Enum.FlightType;
import com.tgi.springAirlines.Exception.ResourceNotFoundException;
import com.tgi.springAirlines.Exception.handleFoundException;
import com.tgi.springAirlines.Repository.CompanyRepository;
import com.tgi.springAirlines.Repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepository flightRepository;
	@Autowired
	CompanyRepository companyRepository;

	@Override
	public List<FlightResponseDto> getAllFlight()throws Exception {
		try {
		List<Flight> flight = flightRepository.findAll();
		List<FlightResponseDto> flightList = new ArrayList<FlightResponseDto>(flight.size());
		for (Flight u : flight)
			flightList.add(addFlightToFlightResDto(u));
		return flightList;
	    }catch(Exception e) {

	    	   throw new handleFoundException("something went wrong:"+e.getMessage());
	       }
	}

	private FlightResponseDto addFlightToFlightResDto(Flight flight) {
		FlightResponseDto flightResponseDto = new FlightResponseDto();
		flightResponseDto.setId(flight.getId());
		flightResponseDto.setFlightType(flight.getFlightType());
		flightResponseDto.setDescription(flight.getDescription());
		flightResponseDto.setStatus(flight.isStatus());
		flightResponseDto.setFlightName(flight.getFlightName());
		flightResponseDto.setSeats(flight.getSeats());
		flightResponseDto.setSeats(flight.getSeats());
		flightResponseDto.setCompanyName(flight.getCompany().getCompanyName());
		return flightResponseDto;
	}


	@Override
	public ResponseEntity<?> createFlight(FlightRequestDto flightRequestDto)throws Exception {
      try {
    	  
    	  Optional<Flight>flight1=flightRepository.findByflightName(flightRequestDto.getFlightName());
    	  if(!flight1.isEmpty()) {
    		  throw new ResourceNotFoundException("FlightName is already Exist");
    	  }
    	  Optional<Company>company=companyRepository.findById(flightRequestDto.getCompanyId());
    	  if(company.isEmpty()) {
    		  throw new ResourceNotFoundException("invalid companyId");
    	  }
    	  
		Flight flight = new Flight();
		flight.setId(flight.getId());
		flight.setFlightName(flightRequestDto.getFlightName());
		flight.setDescription(flightRequestDto.getDescription());
	    flight.setFlightType(flightRequestDto.getFlightType());
		flight.setStatus(true);
		flight.setCompany(companyRepository.getById(flightRequestDto.getCompanyId()));
		flight.setSeats(flightRequestDto.getSeats());
		flight = flightRepository.save(flight);
		
		FlightResponseDto flightResponseDto = new FlightResponseDto();
		flightResponseDto.setId(flight.getId());
		flightResponseDto.setSeats(flight.getSeats());
		flightResponseDto.setFlightType(flight.getFlightType());
		flightResponseDto.setDescription(flight.getDescription());
		flightResponseDto.setStatus(flight.isStatus());
		flightResponseDto.setFlightName(flight.getFlightName());
		flightResponseDto.setCompanyName(flight.getCompany().getCompanyName());
		return new ResponseEntity(flightResponseDto, HttpStatus.OK);
       }catch(Exception e) {
    	   //e.printStackTrace();
    	 //  return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    	   throw new handleFoundException("something went wrong:"+e.getMessage());
       }
		
		
	}

	@Override
	public ResponseEntity<?> getFlightById(Long id)throws Exception {
        try {
		Flight flight = flightRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Country id not found :" + id));
		
		FlightResponseDto flightResponseDto = new FlightResponseDto();
		flightResponseDto.setId(flight.getId());
		flightResponseDto.setFlightType(flight.getFlightType());
		flightResponseDto.setDescription(flight.getDescription());
		flightResponseDto.setStatus(flight.isStatus());
		flightResponseDto.setFlightName(flight.getFlightName());
		flightResponseDto.setSeats(flight.getSeats());
		flightResponseDto.setCompanyName(flight.getCompany().getCompanyName());
		return new ResponseEntity(flightResponseDto, HttpStatus.OK);
	    }catch(Exception e) {

	    	   throw new handleFoundException("something went wrong:"+e.toString());
	       }
	}

	@Override
	public ResponseEntity<?> updateFlight(FlightRequestDto flightRequestDto)throws Exception {
		try {
	    	  Optional<Flight>flight=flightRepository.findByflightName(flightRequestDto.getFlightName());
	    	  if(!flight.isEmpty()) {
	    		  throw new ResourceNotFoundException("FlightName is already Exist");
	    	  }
	    	  Optional<Company>company=companyRepository.findById(flightRequestDto.getCompanyId());
	    	  if(company.isEmpty()) {
	    		  throw new ResourceNotFoundException("invalid companyId");
	    	  }
	
		Flight flight1 = new Flight();
		flight1.setId(flightRequestDto.getId());
		flight1.setFlightName(flightRequestDto.getFlightName());
	    flight1.setDescription(flightRequestDto.getDescription());
		flight1.setFlightType(flightRequestDto.getFlightType());
		flight1.setSeats(flightRequestDto.getSeats());
		flight1 = flightRepository.save(flight1);
		
		FlightResponseDto flightResponseDto = new FlightResponseDto();
		flightResponseDto.setId(flight1.getId());
	    flightResponseDto.setFlightType(flight1.getFlightType());
		flightResponseDto.setDescription(flight1.getDescription());
		flightResponseDto.setStatus(flight1.isStatus());
		flightResponseDto.setFlightName(flight1.getFlightName());
		flightResponseDto.setSeats(flight1.getSeats());
		flightResponseDto.setCompanyName(flight1.getCompany().getCompanyName());
		return new ResponseEntity(flightResponseDto, HttpStatus.OK);
	    }catch(Exception e) {

	    	   throw new handleFoundException("something went wrong:"+e.getMessage());
	       }
	}

}
