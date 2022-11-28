package com.tgi.springAirlines.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tgi.springAirlines.Dto.CityRequestDto;
import com.tgi.springAirlines.Dto.CityResposneDto;

public interface CityService {

	public List<CityResposneDto> getAllCity()throws Exception;

	public ResponseEntity<?> createCity(CityRequestDto cityRequestDto)throws Exception;

	public ResponseEntity<?> getCityById(Long id)throws Exception;

	public ResponseEntity<?> updateCity(CityRequestDto cityRequestDto)throws Exception;

}
