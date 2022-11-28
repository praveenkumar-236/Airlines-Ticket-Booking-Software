package com.tgi.springAirlines.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tgi.springAirlines.Dto.StateRequestDto;
import com.tgi.springAirlines.Dto.StateResponseDto;
import com.tgi.springAirlines.Service.StateService;



@RestController
@RequestMapping("/state")
public class StateController {
	@Autowired
	StateService stateService;

	@RequestMapping(value="/getAllState",method = RequestMethod.GET)
	public List<StateResponseDto>getAllState()throws Exception{
		return stateService.getAllState();
	}
	@RequestMapping(value="/createState",method = RequestMethod.POST)
    public ResponseEntity<?>createState(@RequestBody StateRequestDto stateRequestDto )throws Exception{
	    return stateService.createState(stateRequestDto);
}
	@RequestMapping(value="/getStateById{id}",method = RequestMethod.GET)
    public ResponseEntity<?>getStateById(@PathVariable("id")Long id)throws Exception{
        return stateService.getStateById(id); 
}
	@RequestMapping(value="/updateState",method = RequestMethod.PUT)
	public ResponseEntity<?>updateState(@RequestBody StateRequestDto stateRequestDto)throws Exception{
		return stateService.updateState(stateRequestDto);
	}

}
