package com.tgi.springAirlines.Service;

import java.text.ParseException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tgi.springAirlines.Dto.AirlinesScheduleReqDto;
import com.tgi.springAirlines.Dto.AirlinesScheduleResDto;



public interface AirlinesScheduleService {

	List<AirlinesScheduleResDto> getAllAirlinesSchedule();

	ResponseEntity<?> createAirlinesSchedule(AirlinesScheduleReqDto airlinesScheduleReqDto);

	ResponseEntity<?> getAirlinesScheduleById(Long id);

	ResponseEntity<?> updateAirlinesSchedule(AirlinesScheduleReqDto airlinesScheduleReqDto);

}
