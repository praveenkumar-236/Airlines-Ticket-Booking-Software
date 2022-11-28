package com.tgi.springAirlines.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tgi.springAirlines.Entity.Airlines;

public interface AirlinesService {

	public List<Airlines> getAll()throws Exception;

	public ResponseEntity<?> createAirlines(Airlines airlines)throws Exception;

	public ResponseEntity<?> getAirlinesById(Long id)throws Exception;

	public ResponseEntity<?> updateAirlines(Airlines airlines)throws Exception;



}
