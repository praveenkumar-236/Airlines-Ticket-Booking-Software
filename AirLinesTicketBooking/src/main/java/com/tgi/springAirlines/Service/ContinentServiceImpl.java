package com.tgi.springAirlines.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgi.springAirlines.Dto.ContinentRequestDto;
import com.tgi.springAirlines.Entity.Continent;
import com.tgi.springAirlines.Exception.ResourceNotFoundException;
import com.tgi.springAirlines.Exception.handleFoundException;
import com.tgi.springAirlines.Repository.ContinentRepository;

@Service
public class ContinentServiceImpl implements ContinentService {
	@Autowired
	ContinentRepository continentRepository;

	@Override
	public List<Continent> getAllContinent()throws Exception {
         try {
		List<Continent> continent = continentRepository.findAll();
		return continent;
 		} catch (Exception e) {

			throw new handleFoundException("something went wrong:" + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> createContainent(ContinentRequestDto continentRequestDto)throws Exception {
		try {
		Optional<Continent> continentValid=continentRepository.findBycontinentName(continentRequestDto.getContinentName());
		if(!continentValid.isEmpty()) {
			throw new ResourceNotFoundException("ContinentName is already Exist");
		}
		Optional<Continent>continentShortCode=continentRepository.findBycontinentShortCode(continentRequestDto.getContinentShortCode());
		if(!continentShortCode.isEmpty()) {
			throw new ResourceNotFoundException("ContinentShortCode is already Exist");
		}
		
		
		
		
		if (continentRequestDto.getContinentShortCode().length() > 3) {
			return new ResponseEntity("Required length with in 3 characters", HttpStatus.OK);
		}

		Continent continent = new Continent();
		continent.setContinentName(continentRequestDto.getContinentName());
		continent.setContinentShortCode(continentRequestDto.getContinentShortCode());
	
		continent.setStatus(true);

		continentRepository.save(continent);

		return new ResponseEntity(continent, HttpStatus.OK);
		} catch (Exception e) {

			throw new handleFoundException("something went wrong:" + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> getContainentById(Long id)throws Exception {
		try {
		Continent continent1 = continentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Country id not found :" + id));
		
		return new ResponseEntity(continent1, HttpStatus.OK);
		} catch (Exception e) {

			throw new handleFoundException("something went wrong:" + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> updateContinent(ContinentRequestDto continentRequestDto)throws Exception {
		try {
		Optional<Continent> continentValid=continentRepository.findBycontinentName(continentRequestDto.getContinentName());
		if(!continentValid.isEmpty()) {
			throw new ResourceNotFoundException("ContinentName is already Exist");
		}
		Optional<Continent>continentShortCode=continentRepository.findBycontinentShortCode(continentRequestDto.getContinentShortCode());
		if(!continentShortCode.isEmpty()) {
			throw new ResourceNotFoundException("ContinentShortCode is already Exist");
		}

		Optional<Continent> continent = continentRepository.findById(continentRequestDto.getId());
		if(continent.isEmpty()) {
			throw new ResourceNotFoundException("invalid id");
		}
		Continent continent1 = continent.get();
      

		continent1.setContinentName(continentRequestDto.getContinentName());
		continent1.setContinentShortCode(continentRequestDto.getContinentShortCode());
		continent1.setId(continentRequestDto.getId());
		continent1.setStatus(true);
		continentRepository.save(continent1);
		return new ResponseEntity(continent1, HttpStatus.OK);
		} catch (Exception e) {

			throw new handleFoundException("something went wrong:" + e.getMessage());
		}
	}

}
