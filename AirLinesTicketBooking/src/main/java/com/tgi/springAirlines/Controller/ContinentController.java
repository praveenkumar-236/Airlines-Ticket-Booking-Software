package com.tgi.springAirlines.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tgi.springAirlines.Dto.ContinentRequestDto;
import com.tgi.springAirlines.Entity.Continent;
import com.tgi.springAirlines.Service.ContinentService;

@RestController
@RequestMapping("/continent")
public class ContinentController {
	@Autowired
	ContinentService continentService;
	@RequestMapping(value="/getAllContinent",method = RequestMethod.GET)
	public List<Continent>getAllContinent()throws Exception{
		return continentService.getAllContinent();
		
	}
	@RequestMapping(value="/createContainent",method = RequestMethod.POST)
	public ResponseEntity<?>createContainent(@RequestBody ContinentRequestDto continentRequestDto)throws Exception{
		return continentService.createContainent(continentRequestDto);
	}
	@RequestMapping(value = "/getContainentById/{id}", method = RequestMethod.GET)
	public ResponseEntity<?>getContainentById(@PathVariable("id")Long id)throws Exception{
		return continentService.getContainentById(id);
		
	}
	@RequestMapping(value="/updateContinent",method = RequestMethod.PUT)
	public ResponseEntity<?>updateContinent(@RequestBody ContinentRequestDto continentRequestDto)throws Exception{
		return continentService.updateContinent(continentRequestDto);
	}
	

}
