package com.tgi.springAirlines.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tgi.springAirlines.Dto.CountryRequestDto;
import com.tgi.springAirlines.Dto.CountryResponseDto;

public interface CountryService {

	public List<CountryResponseDto> getAllCountry()throws Exception;

	public ResponseEntity<?> createCountry(CountryRequestDto countryRequestDto)throws Exception;

	public ResponseEntity<?> getCountryById(Long id)throws Exception;

	public ResponseEntity<?> updateCountry(CountryRequestDto countryRequestDto)throws Exception;





}
