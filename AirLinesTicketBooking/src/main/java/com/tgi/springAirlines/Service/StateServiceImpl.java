package com.tgi.springAirlines.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgi.springAirlines.Dto.StateRequestDto;
import com.tgi.springAirlines.Dto.StateResponseDto;
import com.tgi.springAirlines.Entity.Country;
import com.tgi.springAirlines.Entity.State;
import com.tgi.springAirlines.Exception.ResourceNotFoundException;
import com.tgi.springAirlines.Exception.handleFoundException;
import com.tgi.springAirlines.Repository.CountryRepository;
import com.tgi.springAirlines.Repository.StateRepository;

@Service
public class StateServiceImpl implements StateService{
	@Autowired
	StateRepository stateRepository;
	@Autowired
	CountryRepository countryRepository;
	@Override
	public List<StateResponseDto> getAllState()throws Exception {
		try {
		List<State> state = stateRepository.findAll();
		List<StateResponseDto> stateList = new ArrayList<StateResponseDto>(state.size());
		for (State u : state)
			stateList.add(addstateToStateResDto(u));
		return stateList;
	    }catch(Exception e) {

	    	   throw new handleFoundException("something went wrong:"+e.getMessage());
	       }
	}

	public StateResponseDto addstateToStateResDto(State state) {
		StateResponseDto stateResponseDto = new StateResponseDto();
		stateResponseDto.setId(state.getId());
		stateResponseDto.setStateName(state.getStateName());
		stateResponseDto.setStatus(state.isStatus());
		stateResponseDto.setStateShortCode(state.getStateShortCode());
		stateResponseDto.setCountryId(state.getCountry().getId());
		stateResponseDto.setCountryName(state.getCountry().getCountryName());
		stateResponseDto.setContinentName(state.getCountry().getContinent().getContinentName());

		return stateResponseDto;
	}

	@Override
	public ResponseEntity<?> createState(StateRequestDto stateRequestDto)throws Exception {
		try {
		Optional<State> state=stateRepository.findByStateName(stateRequestDto.getStateName());
	
		if(!state.isEmpty()){
			throw new ResourceNotFoundException("stateName is already exist");
			
		}
		Optional<State>stateShortCode=stateRepository.findBystateShortCode(stateRequestDto.getStateShortCode());
		if(!stateShortCode.isEmpty()) {
			throw new ResourceNotFoundException("stateShortCode is already exist");
		}
		
		
		Optional<Country> country = countryRepository.findById(stateRequestDto.getCountrytId());
		
		if (country.isEmpty()) {
			throw new ResourceNotFoundException("Invalid CountryId");
		} 
	    if(stateRequestDto.getStateShortCode().length()>3) {
	      	  return new ResponseEntity("Required length with in 3 characters",HttpStatus.OK);
	        }
		
		State state1 = new State();
		state1.setStateName(stateRequestDto.getStateName());
		state1.setStateShortCode(stateRequestDto.getStateShortCode());
		state1.setCountry(countryRepository.getById(stateRequestDto.getCountrytId()));
		state1.setStatus(true);

		state1 = stateRepository.save(state1);
		StateResponseDto stateResponseDto = new StateResponseDto();
		stateResponseDto.setId(state1.getId());
		stateResponseDto.setStateName(state1.getStateName());
		stateResponseDto.setStateShortCode(state1.getStateShortCode());
		stateResponseDto.setCountryId(state1.getCountry().getId());
		stateResponseDto.setCountryName(state1.getCountry().getCountryName());
		stateResponseDto.setStatus(state1.isStatus());
		stateResponseDto.setContinentName(state1.getCountry().getContinent().getContinentName());
		
		return new ResponseEntity(stateResponseDto, HttpStatus.OK);
	    }catch(Exception e) {

	    	   throw new handleFoundException("something went wrong:"+e.getMessage());
	       }
		
		
		
	}

	@Override
	public ResponseEntity<?> getStateById(Long id)throws Exception {
		try {
		State state = stateRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("state id not found :" + id));
		
		StateResponseDto stateResponseDto = new StateResponseDto();
		stateResponseDto.setId(state.getId());
		stateResponseDto.setStateName(state.getStateName());
		stateResponseDto.setStateShortCode(state.getStateShortCode());
		stateResponseDto.setCountryId(state.getCountry().getId());
		stateResponseDto.setCountryName(state.getCountry().getCountryName());
		stateResponseDto.setStatus(state.isStatus());
		stateResponseDto.setContinentName(state.getCountry().getContinent().getContinentName());
		
		return new ResponseEntity(stateResponseDto, HttpStatus.OK);
	} catch (Exception e) {

		throw new handleFoundException("something went wrong:" + e.getMessage());
	}

}

@Override
public ResponseEntity<?> updateState(StateRequestDto stateRequestDto) throws Exception {
	try {
		Optional<State> stateValid = stateRepository.findByStateName(stateRequestDto.getStateName());
		if (!stateValid.isEmpty()) {
			throw new ResourceNotFoundException("stateName is already exist");

		}
		Optional<State> stateShortCode = stateRepository.findBystateShortCode(stateRequestDto.getStateShortCode());
		if (!stateShortCode.isEmpty()) {
			throw new ResourceNotFoundException("stateShortCode is already exist");
		}

		Optional<State> state1 = stateRepository.findById(stateRequestDto.getStateId());
		if (state1.isEmpty()) {
			throw new ResourceNotFoundException("invalid state id");
		}
		State state = state1.get();

		state.setId(stateRequestDto.getStateId());
		state.setCountry(countryRepository.getById(stateRequestDto.getCountrytId()));
		state.setStateName(stateRequestDto.getStateName());
		state.setStateShortCode(stateRequestDto.getStateShortCode());
		state.setStatus(true);
		state = stateRepository.save(state);

		StateResponseDto stateResponseDto = new StateResponseDto();
		stateResponseDto.setId(state.getId());
		stateResponseDto.setStateName(state.getStateName());
		stateResponseDto.setStateShortCode(state.getStateShortCode());
		stateResponseDto.setCountryId(state.getCountry().getId());
		stateResponseDto.setCountryName(state.getCountry().getCountryName());
		stateResponseDto.setStatus(state.isStatus());
		stateResponseDto.setContinentName(state.getCountry().getContinent().getContinentName());

		return new ResponseEntity(stateResponseDto, HttpStatus.OK);
	} catch (Exception e) {

		throw new handleFoundException("something went wrong:" + e.getMessage());
	}

}

}
