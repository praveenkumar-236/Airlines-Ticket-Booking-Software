package com.tgi.springAirlines.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgi.springAirlines.Dto.CityRequestDto;
import com.tgi.springAirlines.Dto.CityResposneDto;
import com.tgi.springAirlines.Entity.City;
import com.tgi.springAirlines.Entity.State;
import com.tgi.springAirlines.Exception.ResourceNotFoundException;
import com.tgi.springAirlines.Exception.handleFoundException;
import com.tgi.springAirlines.Repository.CityRepository;
import com.tgi.springAirlines.Repository.StateRepository;

@Service
public class CityServiceImpl implements CityService {
	@Autowired
	CityRepository cityRepository;
	@Autowired
	StateRepository stateRepository;
	
	@Override
	public List<CityResposneDto> getAllCity() throws Exception{
		try {
	List<City>city=cityRepository.findAll();
	List<CityResposneDto>cityList=new ArrayList<CityResposneDto>(city.size());
	for(City c:city) 
		cityList.add(addCityToCityResponseDto(c));
	
		return cityList;
		} catch (Exception e) {

			throw new handleFoundException("something went wrong:" + e.getMessage());
		}
	}

	public CityResposneDto addCityToCityResponseDto(City city) {
		CityResposneDto cityResposneDto=new CityResposneDto();
		cityResposneDto.setCityName(city.getCityName());
		cityResposneDto.setCityShortCode(city.getCityShortCode());
		cityResposneDto.setStatus(city.isStatus());
		cityResposneDto.setId(city.getId());
		cityResposneDto.setStateName(city.getState().getStateName());
		cityResposneDto.setStateId(city.getState().getId());
		cityResposneDto.setCountryName(city.getState().getCountry().getCountryName());
		
	
		
		return cityResposneDto;
	}

	@Override
	public ResponseEntity<?> createCity(CityRequestDto cityRequestDto)throws Exception {
		try {
		Optional<City> cityValid=cityRepository.findBycityName(cityRequestDto.getCityName());
		if(!cityValid.isEmpty()) {
			throw new ResourceNotFoundException("cityName is already exist");
		}
		Optional<City>cityShortCode=cityRepository.findBycityShortCode(cityRequestDto.getCityShortCode());
		if(!cityShortCode.isEmpty()) {
			throw new ResourceNotFoundException("cityShortCode is already Exist");
		}
		Optional<State> stateId = stateRepository.findById(cityRequestDto.getStateId());
		if (stateId.isEmpty()) {
			throw new ResourceNotFoundException("Invalid stateId");
		} 
	    if(cityRequestDto.getCityShortCode().length()>3) {
	      	  return new ResponseEntity("Required length with in 3 characters",HttpStatus.OK);
	        }
		
		City city=new City();
	
		city.setState(stateRepository.getById(cityRequestDto.getStateId()));
		city.setCityName(cityRequestDto.getCityName());
		city.setCityShortCode(cityRequestDto.getCityShortCode());
		city.setStatus(true);
		city=cityRepository.save(city);
		
		CityResposneDto cityResposneDto=new CityResposneDto();
		cityResposneDto.setCityName(city.getCityName());
		cityResposneDto.setCityShortCode(city.getCityShortCode());
		cityResposneDto.setStatus(city.isStatus());
		cityResposneDto.setStateName(city.getState().getStateName());
		cityResposneDto.setStateId(city.getState().getId());
		cityResposneDto.setId(city.getId());
		cityResposneDto.setCountryName(city.getState().getCountry().getCountryName());
		
		return new ResponseEntity(cityResposneDto,HttpStatus.OK);
		} catch (Exception e) {

			throw new handleFoundException("something went wrong:" + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> getCityById(Long id)throws Exception {
		try {
		City city = cityRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("state id not found :" + id));
		CityResposneDto cityResposneDto=new CityResposneDto();
		cityResposneDto.setCityName(city.getCityName());
		cityResposneDto.setCityShortCode(city.getCityShortCode());
		cityResposneDto.setStatus(city.isStatus());
		cityResposneDto.setId(city.getId());
		cityResposneDto.setStateName(city.getState().getStateName());
		cityResposneDto.setStateId(city.getState().getId());
		cityResposneDto.setCountryName(city.getState().getCountry().getCountryName());
		
		return new ResponseEntity(cityResposneDto, HttpStatus.OK);
		} catch (Exception e) {

			throw new handleFoundException("something went wrong:" + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> updateCity(CityRequestDto cityRequestDto)throws Exception {
		try {
		Optional<City> cityValid=cityRepository.findBycityName(cityRequestDto.getCityName());
		if(!cityValid.isEmpty()) {
			throw new ResourceNotFoundException("cityName is already exist");
		}
		Optional<City>cityShortCode=cityRepository.findBycityShortCode(cityRequestDto.getCityShortCode());
		if(!cityShortCode.isEmpty()) {
			throw new ResourceNotFoundException("cityShortCode is already Exist");
		}
	
		Optional<City>city1=cityRepository.findById(cityRequestDto.getCityId());
		if(city1.isEmpty()) {
			throw new ResourceNotFoundException("invalid city id");
		}
		City city=city1.get();
		city.setId(cityRequestDto.getCityId());
		city.setCityName(cityRequestDto.getCityName());
		city.setCityShortCode(cityRequestDto.getCityShortCode());
		city.setStatus(true);
		city=cityRepository.save(city);
		
		
		CityResposneDto cityResposneDto=new CityResposneDto();
		cityResposneDto.setId(city.getId());
		cityResposneDto.setCityName(city.getCityName());
		cityResposneDto.setCityShortCode(city.getCityShortCode());
		cityResposneDto.setStatus(city.isStatus());
		cityResposneDto.setStateName(city.getState().getStateName());
		cityResposneDto.setStateId(city.getState().getId());
		cityResposneDto.setCountryName(city.getState().getCountry().getCountryName());
		
		
	
		return new ResponseEntity(cityResposneDto,HttpStatus.OK);
		} catch (Exception e) {

			throw new handleFoundException("something went wrong:" + e.getMessage());
		}
	}

}
