package com.tgi.springAirlines.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tgi.springAirlines.Dto.CityRequestDto;
import com.tgi.springAirlines.Dto.CityResposneDto;
import com.tgi.springAirlines.Service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {
	@Autowired
	CityService cityService;
	@RequestMapping(value="/getAllCity",method = RequestMethod.GET)
	public List<CityResposneDto>getAllCity()throws Exception{
		return cityService.getAllCity();
	}
	@RequestMapping(value="/createCity",method = RequestMethod.POST)
	public ResponseEntity<?>createCity(@RequestBody CityRequestDto CityRequestDto)throws Exception{
		return cityService.createCity(CityRequestDto);
	}
	@RequestMapping(value="/getCityById{id}",method = RequestMethod.GET)
	public ResponseEntity<?>getCityById(@PathVariable("id")Long id)throws Exception{
		return cityService.getCityById(id);
	}
	@RequestMapping(value="/createCity",method = RequestMethod.PUT)
	public ResponseEntity<?>updateCity(@RequestBody CityRequestDto CityRequestDto)throws Exception{
		return cityService.updateCity(CityRequestDto);
	}

}
