package com.tgi.springAirlines.Controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tgi.springAirlines.Dto.AirlinesScheduleReqDto;
import com.tgi.springAirlines.Dto.AirlinesScheduleResDto;
import com.tgi.springAirlines.Service.AirlinesScheduleService;

@RestController
@RequestMapping("/AirlinesScheduleController")
public class AirlinesScheduleController {

	@Autowired
	AirlinesScheduleService airlinesScheduleService;
	@RequestMapping(value="/getAllAirlinesSchedule",method = RequestMethod.GET)
	public List<AirlinesScheduleResDto>getAllAirlinesSchedule(){
		return airlinesScheduleService.getAllAirlinesSchedule();
	}
	@RequestMapping(value="/createAirlinesSchedule",method = RequestMethod.POST)
	public ResponseEntity<?>createAirlinesSchedule(@RequestBody AirlinesScheduleReqDto airlinesScheduleReqDto ){
		return airlinesScheduleService.createAirlinesSchedule(airlinesScheduleReqDto);
	}
	@RequestMapping(value="/getAirlinesScheduleById{id}",method = RequestMethod.GET)
	public ResponseEntity<?>getAirlinesScheduleById(@PathVariable("id")Long id){
		return airlinesScheduleService.getAirlinesScheduleById(id); 
	}
	@RequestMapping(value="/updateAirlinesSchedule",method = RequestMethod.PUT)
	public ResponseEntity<?>updateAirlinesSchedule(@RequestBody AirlinesScheduleReqDto airlinesScheduleReqDto){
		return airlinesScheduleService.updateAirlinesSchedule(airlinesScheduleReqDto);
	}
	
	
}
