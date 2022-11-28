package com.tgi.springAirlines.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tgi.springAirlines.Entity.Airlines;
import com.tgi.springAirlines.Service.AirlinesService;

@RestController
@RequestMapping("/Airlines")
public class AirlinesController {
	@Autowired
	AirlinesService airlinesService;
	
	@RequestMapping(value="/getAll",method = RequestMethod.GET)
	public List<Airlines>getAll()throws Exception{
		
		return airlinesService.getAll();
	}
	@RequestMapping(value="/createAirlines",method = RequestMethod.POST)
	public ResponseEntity<?>createAirlines(@RequestBody Airlines airlines)throws Exception{
		return airlinesService.createAirlines(airlines);
	}
	@RequestMapping(value="/getAirlinesById{id}",method = RequestMethod.GET)
	public ResponseEntity<?>getAirlinesById(@PathVariable("id")Long id)throws Exception{
		return airlinesService.getAirlinesById(id);
	}
	@RequestMapping(value="/updateAirlines",method = RequestMethod.PUT)
	public ResponseEntity<?>updateAirlines(@RequestBody Airlines airlines)throws Exception{
		return airlinesService.updateAirlines(airlines);
	}

}
