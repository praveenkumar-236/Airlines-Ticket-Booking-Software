package com.tgi.springAirlines.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgi.springAirlines.Entity.Airlines;
import com.tgi.springAirlines.Exception.handleFoundException;
import com.tgi.springAirlines.Repository.AirlinesRepository;
@Service
public class AirlinesServiceImpl implements AirlinesService {

	@Autowired
	AirlinesRepository airlinesRepository;

	@Override
	public List<Airlines> getAll()throws Exception {
		try {
	List<Airlines>airline=airlinesRepository.findAll();
		return airline;
		} catch (Exception e) {

			throw new handleFoundException("something went wrong:" + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> createAirlines(Airlines airlines)throws Exception {
		try {
		Airlines air =airlinesRepository.save(airlines);
		 return new ResponseEntity(air,HttpStatus.OK);
		} catch (Exception e) {

			throw new handleFoundException("something went wrong:" + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> getAirlinesById(Long id)throws Exception {
		try {
		Optional<Airlines> air=airlinesRepository.findById(id);
		return new ResponseEntity(air,HttpStatus.OK);
		} catch (Exception e) {

			throw new handleFoundException("something went wrong:" + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> updateAirlines(Airlines airlines)throws Exception {
		try {
		Airlines air =airlinesRepository.save(airlines);
		return new ResponseEntity(air,HttpStatus.OK);
		} catch (Exception e) {

			throw new handleFoundException("something went wrong:" + e.getMessage());
		}
	}
	


	
	
}
