package com.tgi.springAirlines.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgi.springAirlines.Dto.AirportRequestDto;
import com.tgi.springAirlines.Dto.AirportResponseDto;
import com.tgi.springAirlines.Entity.Airport;
import com.tgi.springAirlines.Entity.City;
import com.tgi.springAirlines.Exception.ResourceNotFoundException;
import com.tgi.springAirlines.Exception.handleFoundException;
import com.tgi.springAirlines.Repository.AirportRepository;
import com.tgi.springAirlines.Repository.CityRepository;
import com.tgi.springAirlines.Repository.StateRepository;

@Service
public class AirportServiceImpl implements AirportService {
	@Autowired
	AirportRepository airportRepository;
	@Autowired
	CityRepository cityRepository;
	@Autowired
	StateRepository stateRepository;

	@Override
	public List<AirportResponseDto> getAllAirport()throws Exception {
		try {
		List<Airport> airport = airportRepository.findAll();
		List<AirportResponseDto> airportList = new ArrayList<AirportResponseDto>(airport.size());
		for (Airport c : airport)
			airportList.add(addAirportToAirportResponseDto(c));
        return airportList;
	} catch (Exception e) {

		throw new handleFoundException("something went wrong:" + e.getMessage());
	}
        
	}
	

	public AirportResponseDto addAirportToAirportResponseDto(Airport airport) throws Exception{
		AirportResponseDto airportResponseDto = new AirportResponseDto();
		airportResponseDto.setAirportName(airport.getAirportName());
		airportResponseDto.setAirportShortCode(airport.getAirportShortCode());
		airportResponseDto.setId(airport.getId());
		airportResponseDto.setStatus(airport.isStatus());
		airportResponseDto.setCityName(airport.getCity().getCityName());
		airportResponseDto.setCityId(airport.getCity().getId());
		airportResponseDto.setStateName(airport.getCity().getState().getStateName());
		airportResponseDto.setCountryName(airport.getCity().getState().getCountry().getCountryName());
		
		return airportResponseDto;
    
	}
	
	

	@Override
	public ResponseEntity<?> createAirport(AirportRequestDto airportRequestDto) throws Exception{
		try {
		List<Airport> airportValid=airportRepository.findByairportName(airportRequestDto.getAirportName());
		if(!airportValid.isEmpty()) {
			throw new ResourceNotFoundException("airportName is already exist");
		}
		Optional<Airport> airportShortCode=airportRepository.findByairportShortCode(airportRequestDto.getAirportShortCode());
		if(!airportShortCode.isEmpty()) {
			throw new ResourceNotFoundException("airportShortCode is already exist");
		}
		
		Optional<City> city = cityRepository.findById(airportRequestDto.getCityId());
		if (city.isEmpty()) {
			throw new ResourceNotFoundException("Invalid cityid");
		} 
		if(airportRequestDto.getAirportShortCode().length()>3) {
	      	  return new ResponseEntity("Required length with in 3 characters",HttpStatus.OK);
	        }
		Airport airport=new Airport();
		airport.setAirportName(airportRequestDto.getAirportName());
		airport.setAirportShortCode(airportRequestDto.getAirportShortCode());
		airport.setCity(cityRepository.getById(airportRequestDto.getCityId()));
		airport.setStatus(true);
		airport=airportRepository.save(airport);
		
		AirportResponseDto airportResponseDto = new AirportResponseDto();
		airportResponseDto.setAirportName(airport.getAirportName());
		airportResponseDto.setAirportShortCode(airport.getAirportShortCode());
		airportResponseDto.setId(airport.getId());
		airportResponseDto.setStatus(airport.isStatus());
		airportResponseDto.setCityName(airport.getCity().getCityName());
		airportResponseDto.setCityId(airport.getCity().getId());
		airportResponseDto.setStateName(airport.getCity().getState().getStateName());
		airportResponseDto.setCountryName(airport.getCity().getState().getCountry().getCountryName());
		
		return new ResponseEntity(airportResponseDto,HttpStatus.OK);
	       }catch(Exception e) {

		 	      throw new handleFoundException("something went wrong:"+e.getMessage());
		       }
	}

	@Override
	public ResponseEntity<?> getAirportById(Long id)throws Exception {
		try {
		Airport airport = airportRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("airport id not found :" + id));
		
		AirportResponseDto airportResponseDto = new AirportResponseDto();
		airportResponseDto.setAirportName(airport.getAirportName());
		airportResponseDto.setAirportShortCode(airport.getAirportShortCode());
		airportResponseDto.setId(airport.getId());
		airportResponseDto.setStatus(airport.isStatus());
		airportResponseDto.setCityName(airport.getCity().getCityName());
		airportResponseDto.setCityId(airport.getCity().getId());
		airportResponseDto.setStateName(airport.getCity().getState().getStateName());
		airportResponseDto.setCountryName(airport.getCity().getState().getCountry().getCountryName());
			
		return new ResponseEntity(airport,HttpStatus.OK);
	       }catch(Exception e) {

		 	      throw new handleFoundException("something went wrong:"+e.getMessage());
		       }
	}

	@Override
	public ResponseEntity<?> updateAirport(AirportRequestDto airportRequestDto)throws Exception {
		try {
		List<Airport> airportValid=airportRepository.findByairportName(airportRequestDto.getAirportName());
		if(!airportValid.isEmpty()) {
			throw new ResourceNotFoundException("airportName is already exist");
		}
		Optional<Airport>airportShortCode=airportRepository.findByairportShortCode(airportRequestDto.getAirportShortCode());
		if(!airportShortCode.isEmpty()) {
			throw new ResourceNotFoundException("airportShortCode is already exist");
		}
		
        Optional<Airport>airport1=airportRepository.findById(airportRequestDto.getAirportId());
        if(airport1.isEmpty()) {
        	throw new ResourceNotFoundException("invalid Airportid");
        }
        Airport airport=airport1.get();
		AirportResponseDto airportResponseDto = new AirportResponseDto();
		airportResponseDto.setAirportName(airport.getAirportName());
		airportResponseDto.setAirportShortCode(airport.getAirportShortCode());
		airportResponseDto.setId(airport.getId());
		airportResponseDto.setStatus(airport.isStatus());
		airportResponseDto.setCityName(airport.getCity().getCityName());
		airportResponseDto.setCityId(airport.getCity().getId());
		airportResponseDto.setStateName(airport.getCity().getState().getStateName());
		airportResponseDto.setCountryName(airport.getCity().getState().getCountry().getCountryName());
		
		return new ResponseEntity(airportResponseDto,HttpStatus.OK);
	       }catch(Exception e) {

		 	      throw new handleFoundException("something went wrong:"+e.getMessage());
		       }
	}
	
	
	
	

}
