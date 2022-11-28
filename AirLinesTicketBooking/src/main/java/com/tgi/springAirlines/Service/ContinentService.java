package com.tgi.springAirlines.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tgi.springAirlines.Dto.ContinentRequestDto;
import com.tgi.springAirlines.Entity.Continent;



public interface ContinentService {

	List<Continent> getAllContinent()throws Exception;

	public ResponseEntity<?> createContainent(ContinentRequestDto continentRequestDto)throws Exception;

	public ResponseEntity<?> getContainentById(Long id)throws Exception;

	public ResponseEntity<?> updateContinent(ContinentRequestDto continentRequestDto)throws Exception;


	

}
