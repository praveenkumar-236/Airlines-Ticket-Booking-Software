package com.tgi.springAirlines.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgi.springAirlines.Dto.AirlinesScheduleReqDto;
import com.tgi.springAirlines.Dto.AirlinesScheduleResDto;
import com.tgi.springAirlines.Entity.AirlinesSchedule;
import com.tgi.springAirlines.Entity.Airport;
import com.tgi.springAirlines.Entity.Flight;
import com.tgi.springAirlines.Enum.Days;
import com.tgi.springAirlines.Exception.ResourceNotFoundException;
import com.tgi.springAirlines.Repository.AirlinesScheduleRepository;
import com.tgi.springAirlines.Repository.AirportRepository;
import com.tgi.springAirlines.Repository.FlightRepository;

@Service
public class AirlinesScheduleServiceImpl implements AirlinesScheduleService {
	@Autowired
	AirlinesScheduleRepository airlinesScheduleRepository;
	@Autowired
	AirportRepository airportRepository;
	@Autowired
	FlightRepository flightRepository;

 

	@Override
	public List<AirlinesScheduleResDto> getAllAirlinesSchedule() {
		List<AirlinesSchedule> airlinesSchedule = airlinesScheduleRepository.findAll();
		List<AirlinesScheduleResDto> airlinesScheduleList = new ArrayList<AirlinesScheduleResDto>(airlinesSchedule.size());
		for (AirlinesSchedule u : airlinesSchedule)
			airlinesScheduleList.add(addAirlinesScheduleToAirlinesScheduleResDto(u));
		return airlinesScheduleList;
	
	}

	private AirlinesScheduleResDto addAirlinesScheduleToAirlinesScheduleResDto(AirlinesSchedule airlinesSchedule) {
		AirlinesScheduleResDto airlinesScheduleResDto=new AirlinesScheduleResDto();
		airlinesScheduleResDto.setId(airlinesSchedule.getId());
		airlinesScheduleResDto.setFromAirPortId(airlinesSchedule.getFrom().getId());
		airlinesScheduleResDto.setToAirportId(airlinesSchedule.getFrom().getId());
		airlinesScheduleResDto.setFlightId(airlinesSchedule.getFlight().getId());
		airlinesScheduleResDto.setStatus(airlinesSchedule.isStatus());
		airlinesScheduleResDto.setSeats(airlinesSchedule.getFlight().getSeats());
		airlinesScheduleResDto.setFlightName(airlinesSchedule.getFlight().getFlightName());
		airlinesScheduleResDto.setFromAirport(airlinesSchedule.getFrom().getAirportName()+"-"+airlinesSchedule.getFrom().getAirportShortCode());
		airlinesScheduleResDto.setToAirport(airlinesSchedule.getTo().getAirportName()+"-"+airlinesSchedule.getFrom().getAirportShortCode());
		airlinesScheduleResDto.setArrivalTime(airlinesSchedule.getArrivalTime());
		airlinesScheduleResDto.setDepartureTime(airlinesSchedule.getDepartureTime());
		airlinesScheduleResDto.setDays(airlinesSchedule.getDays());


		return airlinesScheduleResDto;
	}

	@Override
	public ResponseEntity<?> createAirlinesSchedule(AirlinesScheduleReqDto airlinesScheduleReqDto) {
		String frAirport=airportRepository.getById(airlinesScheduleReqDto.getFromAirPortId()).getAirportName();
		String frShortCode=airportRepository.getById(airlinesScheduleReqDto.getFromAirPortId()).getAirportShortCode();
		String toAirport=airportRepository.getById(airlinesScheduleReqDto.getToAirportId()).getAirportName();
		String toShortCode=airportRepository.getById(airlinesScheduleReqDto.getToAirportId()).getAirportShortCode();
		
		if(frAirport.equals(toAirport)) {
			throw new ResourceNotFoundException("airportName not same");
		}
		
		
		Optional<Flight>flight=flightRepository.findById(airlinesScheduleReqDto.getFlightId());
		if(flight.isEmpty()) {
			throw new ResourceNotFoundException("invalid FlightId");
		}
		
		Optional<Airport>airport=airportRepository.findById(airlinesScheduleReqDto.getFromAirPortId());
		if(airport.isEmpty()) {
			throw new ResourceNotFoundException("invalid FromAirportId");
		}
		
		Optional<Airport>airport1=airportRepository.findById(airlinesScheduleReqDto.getToAirportId());
		if(airport1.isEmpty()) {
			throw new ResourceNotFoundException("invalid ToAirportId");
		}
		if(airlinesScheduleReqDto.getFromAirPortId().equals(airlinesScheduleReqDto.getToAirportId())) {
			throw new ResourceNotFoundException("fromAirportId and toAirportId both same try with different id");
		}
		
		
//		 Date start = new Date();
//	     SimpleDateFormat formatter = new SimpleDateFormat("HH:ss");
//	     String timeIn24Hours = formatter.format(start);
         
//		 
//		 LocalDateTime arrivalTime = LocalDateTime.now();
//		 DateTimeFormatter Arrivalobj = DateTimeFormatter.ofPattern("HH:ss");
//		 String arrival = arrivalTime.format(Arrivalobj(airlinesScheduleReqDto.getDepartureTime()));
//		
//		 LocalDateTime departure = LocalDateTime.now();
//		 DateTimeFormatter myDateObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//		 String departure1 = departure.format(Arrivalobj);
		/////////timings Validation 
//         if(airlinesScheduleReqDto.getArrivalTime().isBefore(airlinesScheduleReqDto.getDepartureTime())) {
//        	 throw new ResourceNotFoundException("departureTimegreater than arrival time");
		
//         }
//	     SimpleDateFormat formatter = new SimpleDateFormat("HH:ss");
//	     Date start = new Date();
//	 	Date date = formatter.parse(start);
		
//		DateFormat inputFormat = new SimpleDateFormat("HH:ss");
//		String inputText = "18:16";
//		java.util.Date date = null;
//		try {
//			date = inputFormat.parse(inputText);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		java.sql.Date dateDB = new java.sql.Date(date.getTime());
		
		
		//recent
//	 LocalTime time = LocalTime.now();  
//		 DateFormat inputFormat = new SimpleDateFormat("HH:ss");
//			LocalTime localobj=LocalTime.parse(time,inputFormat);
			
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.ss");
//			String time = "18.41";
//			LocalDateTime localTimeObj = LocalDateTime.parse(time, formatter);
//			LocalTime localTime3 = LocalTime.parse("18:41", DateTimeFormatter.ofPattern("hh:ss "));
		LocalTime ArrivalTime = LocalTime.parse("18:41");
		LocalTime departureTime= LocalTime.parse("16:41");
			
	  ArrayList<String>day=new ArrayList<>();
	  day.add("SUN,MON,WED");
	 
			
//		DateFormat inputFormat = new SimpleDateFormat("HH:mm");
//		String current=airlinesScheduleReqDto.getArrivalTime();
//		try {
//			Date date=inputFormat.parse(current);
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Object request;
		//DateFormat formatter = new SimpleDateFormat("HH:ss");
		//String time=formatter.format(current);
//		 Date currentDate = new Date();
//	     SimpleDateFormat formatter = new SimpleDateFormat("HH:ss");
//	     String timeIn24Hours = formatter.format(currentDate);
		
		
//		String date=airlinesScheduleReqDto.getArrivalTime();
//			Date formatter = null;
//			try {
//				formatter = new SimpleDateFormat("HH:ss").parse(date);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//                String time24hr = date.formatted(formatter);          
		

	     
//		 LocalDateTime myDateObj = LocalDateTime.now();
//		 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//		 String formattedDate = myDateObj.format(myFormatObj);
		 
		
		AirlinesSchedule airlinesSchedule=new AirlinesSchedule();
        airlinesSchedule.setId(airlinesScheduleReqDto.getId());
		airlinesSchedule.setStatus(true);
		airlinesSchedule.setFrom(airportRepository.getById(airlinesScheduleReqDto.getFromAirPortId()));
		airlinesSchedule.setTo(airportRepository.getById(airlinesScheduleReqDto.getToAirportId()));
		airlinesSchedule.setFlight(flightRepository.getById(airlinesScheduleReqDto.getFlightId()));

		airlinesSchedule.setArrivalTime(ArrivalTime);
		airlinesSchedule.setDepartureTime(departureTime);
		// airlinesSchedule.setDepartureTime(inputText);

		airlinesSchedule.setFlightName(flightRepository.getById(airlinesScheduleReqDto.getFlightId()).getFlightName());
		airlinesSchedule.setSeats(flightRepository.getById(airlinesScheduleReqDto.getFlightId()).getSeats());
		airlinesSchedule.setFrommAirport(frAirport);
		airlinesSchedule.setFrommAirportShortCode(frShortCode);
		airlinesSchedule.setTooAirport(toAirport);
		airlinesSchedule.setTooAirportShortCode(toShortCode);
	
		airlinesSchedule.setDays(day);
	
		
		airlinesSchedule=airlinesScheduleRepository.save(airlinesSchedule);
		AirlinesScheduleResDto airlinesScheduleResDto=new AirlinesScheduleResDto();
		airlinesScheduleResDto.setId(airlinesSchedule.getId());
		airlinesScheduleResDto.setFromAirPortId(airlinesSchedule.getFrom().getId());
		airlinesScheduleResDto.setToAirportId(airlinesSchedule.getFrom().getId());
		airlinesScheduleResDto.setFlightId(airlinesSchedule.getFlight().getId());
		airlinesScheduleResDto.setStatus(airlinesSchedule.isStatus());
		airlinesScheduleResDto.setSeats(airlinesSchedule.getFlight().getSeats());
		airlinesScheduleResDto.setFlightName(airlinesSchedule.getFlight().getFlightName());
		airlinesScheduleResDto.setFromAirport(airlinesSchedule.getFrom().getAirportName()+"-"+airlinesSchedule.getFrom().getAirportShortCode());
		airlinesScheduleResDto.setToAirport(airlinesSchedule.getTo().getAirportName()+"-"+airlinesSchedule.getFrom().getAirportShortCode());
		airlinesScheduleResDto.setArrivalTime(airlinesSchedule.getArrivalTime());
		airlinesScheduleResDto.setDepartureTime(airlinesSchedule.getDepartureTime());
		airlinesScheduleResDto.setDays(airlinesSchedule.getDays());
		
		
		return new ResponseEntity(airlinesScheduleResDto,HttpStatus.OK);
	}





	@Override
	public ResponseEntity<?> getAirlinesScheduleById(Long id) {
		AirlinesSchedule airlinesSchedule=airlinesScheduleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("AirlinesSchedule id not found :" + id));
		AirlinesScheduleResDto airlinesScheduleResDto=new AirlinesScheduleResDto();
		airlinesScheduleResDto.setId(airlinesSchedule.getId());
		airlinesScheduleResDto.setFromAirPortId(airlinesSchedule.getFrom().getId());
		airlinesScheduleResDto.setToAirportId(airlinesSchedule.getFrom().getId());
		airlinesScheduleResDto.setFlightId(airlinesSchedule.getFlight().getId());
		airlinesScheduleResDto.setStatus(airlinesSchedule.isStatus());
		airlinesScheduleResDto.setSeats(airlinesSchedule.getFlight().getSeats());
		airlinesScheduleResDto.setFlightName(airlinesSchedule.getFlight().getFlightName());
		airlinesScheduleResDto.setFromAirport(airlinesSchedule.getFrom().getAirportName()+"-"+airlinesSchedule.getFrom().getAirportShortCode());
		airlinesScheduleResDto.setToAirport(airlinesSchedule.getTo().getAirportName()+"-"+airlinesSchedule.getFrom().getAirportShortCode());
		airlinesScheduleResDto.setArrivalTime(airlinesSchedule.getArrivalTime());
		airlinesScheduleResDto.setDepartureTime(airlinesSchedule.getDepartureTime());
		airlinesScheduleResDto.setDays(airlinesSchedule.getDays());
		
		return new ResponseEntity(airlinesScheduleResDto,HttpStatus.OK);
		}

	@Override
	public ResponseEntity<?> updateAirlinesSchedule(AirlinesScheduleReqDto airlinesScheduleReqDto) {
		
		String frAirport=airportRepository.getById(airlinesScheduleReqDto.getFlightId()).getAirportName();
		
		Optional<Flight>flight=flightRepository.findById(airlinesScheduleReqDto.getFlightId());
		if(flight.isEmpty()) {
			throw new ResourceNotFoundException("invalid FlightId");
		}
		
		
		Optional<Airport>airport=airportRepository.findById(airlinesScheduleReqDto.getFromAirPortId());
		if(airport.isEmpty()) {
			throw new ResourceNotFoundException("invalid FromAirportId");
		}
		
		Optional<Airport>airport1=airportRepository.findById(airlinesScheduleReqDto.getToAirportId());
		if(airport1.isEmpty()) {
			throw new ResourceNotFoundException("invalid ToAirportId");
		}
		
		AirlinesSchedule airlinesSchedule=new AirlinesSchedule();
		airlinesSchedule.setId(airlinesScheduleReqDto.getId());
		airlinesSchedule.setFrom(airportRepository.getById(airlinesScheduleReqDto.getFromAirPortId()));
		airlinesSchedule.setTo(airportRepository.getById(airlinesScheduleReqDto.getToAirportId()));
		airlinesSchedule.setFlight(flightRepository.getById(airlinesScheduleReqDto.getFlightId()));
		airlinesSchedule.setStatus(true);
		airlinesSchedule.setFlightName(flightRepository.getById(airlinesScheduleReqDto.getFlightId()).getFlightName());
		airlinesSchedule.setSeats(flightRepository.getById(airlinesScheduleReqDto.getFlightId()).getSeats());
		
		
		
		airlinesSchedule=airlinesScheduleRepository.save(airlinesSchedule);

		AirlinesScheduleResDto airlinesScheduleResDto=new AirlinesScheduleResDto();
		airlinesScheduleResDto.setId(airlinesSchedule.getId());
		airlinesScheduleResDto.setFromAirPortId(airlinesSchedule.getFrom().getId());
		airlinesScheduleResDto.setToAirportId(airlinesSchedule.getFrom().getId());
		airlinesScheduleResDto.setFlightId(airlinesSchedule.getFlight().getId());
		airlinesScheduleResDto.setStatus(airlinesSchedule.isStatus());
		airlinesScheduleResDto.setSeats(airlinesSchedule.getFlight().getSeats());
		airlinesScheduleResDto.setFlightName(airlinesSchedule.getFlight().getFlightName());
		airlinesScheduleResDto.setFromAirport(airlinesSchedule.getFrom().getAirportName()+"-"+airlinesSchedule.getFrom().getAirportShortCode());
		airlinesScheduleResDto.setToAirport(airlinesSchedule.getTo().getAirportName()+"-"+airlinesSchedule.getFrom().getAirportShortCode());
		airlinesScheduleResDto.setArrivalTime(airlinesSchedule.getArrivalTime());
		airlinesScheduleResDto.setDepartureTime(airlinesSchedule.getDepartureTime());
		airlinesScheduleResDto.setDays(airlinesSchedule.getDays());
		
		return new ResponseEntity(airlinesScheduleResDto,HttpStatus.OK);
	}
	
	
	

}
