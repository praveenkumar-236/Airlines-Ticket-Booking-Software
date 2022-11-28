package com.tgi.springAirlines.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tgi.springAirlines.Dto.StateRequestDto;
import com.tgi.springAirlines.Dto.StateResponseDto;

public interface StateService {

	public List<StateResponseDto> getAllState()throws Exception;

	public ResponseEntity<?> createState(StateRequestDto stateRequestDto)throws Exception;

	public ResponseEntity<?> getStateById(Long id)throws Exception;

	public ResponseEntity<?> updateState(StateRequestDto stateRequestDto)throws Exception;

}
