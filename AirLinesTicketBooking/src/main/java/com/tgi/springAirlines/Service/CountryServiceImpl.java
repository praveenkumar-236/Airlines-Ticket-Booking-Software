package com.tgi.springAirlines.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.tgi.springAirlines.Dto.CountryRequestDto;
import com.tgi.springAirlines.Dto.CountryResponseDto;
import com.tgi.springAirlines.Entity.Continent;
import com.tgi.springAirlines.Entity.Country;
import com.tgi.springAirlines.Exception.ResourceNotFoundException;
import com.tgi.springAirlines.Exception.handleFoundException;
import com.tgi.springAirlines.Repository.ContinentRepository;
import com.tgi.springAirlines.Repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepository countryRepository;
	@Autowired
	ContinentRepository continentRepository;

	@Override
	public List<CountryResponseDto> getAllCountry() throws Exception{
		try {
		List<Country> country = countryRepository.findAll();
		List<CountryResponseDto> countryList = new ArrayList<CountryResponseDto>(country.size());
		for (Country u : country)
			countryList.add(addContryToCountryResDto(u));
		return countryList;
		} catch (Exception e) {

			throw new handleFoundException("something went wrong:" + e.getMessage());
		}
	}

	public CountryResponseDto addContryToCountryResDto(Country country) {
		CountryResponseDto countryResponseDto = new CountryResponseDto();
		countryResponseDto.setId(country.getId());
		countryResponseDto.setCountryName(country.getCountryName());
		countryResponseDto.setStatus(country.isStatus());
		countryResponseDto.setCountryShortCode(country.getCountryShortCode());
		countryResponseDto.setContinentId(country.getContinent().getId());
		countryResponseDto.setContinentName(country.getContinent().getContinentName());

		return countryResponseDto;
	}

	@Override
	public ResponseEntity<?> createCountry(CountryRequestDto countryRequestDto)throws Exception {
		try {
		Optional<Country> continentValida=countryRepository.findBycountryName(countryRequestDto.getCountryName());
	     if(!continentValida.isEmpty()) {
			throw new ResourceNotFoundException("countryName is already exist");
		}
	     
	    Optional<Country>countryShortCode=countryRepository.findBycountryShortCode(countryRequestDto.getCountryShortCode());
	    if(!countryShortCode.isEmpty()) {
			throw new ResourceNotFoundException("countryShortCode is already exist");
		}

		Optional<Continent> continent = continentRepository.findById(countryRequestDto.getContinentId());
		if (continent.isEmpty()) {
			throw new ResourceNotFoundException("Invalid ContinentId");
		}
		

		    if(countryRequestDto.getCountryShortCode().length()>3) {
      	  return new ResponseEntity("Required length with in 3 characters",HttpStatus.OK);
        }

		Country country1 = new Country();
		country1.setCountryName(countryRequestDto.getCountryName());
		country1.setContinent(continentRepository.getById(countryRequestDto.getContinentId()));
		country1.setCountryShortCode(countryRequestDto.getCountryShortCode());
		country1.setStatus(true);

		country1 = countryRepository.save(country1);
		// Continent continent=new Continent();
		CountryResponseDto countryResponseDto = new CountryResponseDto();
		countryResponseDto.setId(country1.getId());
		countryResponseDto.setCountryName(country1.getCountryName());
		countryResponseDto.setStatus(country1.isStatus());
		countryResponseDto.setCountryShortCode(country1.getCountryShortCode());
		countryResponseDto.setContinentName(country1.getContinent().getContinentName());
		countryResponseDto.setContinentId(country1.getContinent().getId());

		return new ResponseEntity(countryResponseDto, HttpStatus.OK);
		} catch (Exception e) {

			throw new handleFoundException("something went wrong:" + e.getMessage());
		}

	}

	@Override
	public ResponseEntity<?> getCountryById(Long id)throws Exception {
		try {
		Country country = countryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Country id not found :" + id));
		
		CountryResponseDto countryResponseDto = new CountryResponseDto();
		countryResponseDto.setId(country.getId());
		countryResponseDto.setCountryName(country.getCountryName());
		countryResponseDto.setCountryShortCode(country.getCountryShortCode());
		countryResponseDto.setContinentId(country.getContinent().getId());
		countryResponseDto.setStatus(country.isStatus());
		
		
		return new ResponseEntity(countryResponseDto, HttpStatus.OK);
		} catch (Exception e) {

			throw new handleFoundException("something went wrong:" + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> updateCountry(CountryRequestDto countryRequestDto)throws Exception {
		try {
		Optional<Country> continentValida=countryRepository.findBycountryName(countryRequestDto.getCountryName());
		if(!continentValida.isEmpty()) {
			throw new ResourceNotFoundException("countryName is already exist");
		}
	    Optional<Country>countryShortCode=countryRepository.findBycountryShortCode(countryRequestDto.getCountryShortCode());
	    if(!countryShortCode.isEmpty()) {
			throw new ResourceNotFoundException("countryShortCode is already exist");
		}

	
		
		Optional<Continent> continent = continentRepository.findById(countryRequestDto.getContinentId());
		if (continent.isEmpty()) {
			throw new ResourceNotFoundException("Invalid ContinentId");
		}
		
		
          Optional<Country>country1=countryRepository.findById(countryRequestDto.getCountryId());
          if(country1.isEmpty()) {
        	  throw new ResourceNotFoundException("invalid countryid");
          }
		Country country=country1.get();
		
//		Country country = countryRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Country id not found :" + id));
		
		country.setId(countryRequestDto.getCountryId());
		country.setCountryName(countryRequestDto.getCountryName());
		country.setCountryShortCode(countryRequestDto.getCountryShortCode());
		country.setContinent(continentRepository.getById(countryRequestDto.getContinentId()));
		country.setStatus(true);

		country = countryRepository.save(country);

		CountryResponseDto countryResponseDto = new CountryResponseDto();
		countryResponseDto.setId(country.getId());
		countryResponseDto.setCountryName(country.getCountryName());
		countryResponseDto.setCountryShortCode(country.getCountryShortCode());
		countryResponseDto.setContinentId(country.getContinent().getId());
		countryResponseDto.setStatus(country.isStatus());

		return new ResponseEntity(countryResponseDto, HttpStatus.OK);
	} catch (Exception e) {

		throw new handleFoundException("something went wrong:" + e.getMessage());
	}
}

}
