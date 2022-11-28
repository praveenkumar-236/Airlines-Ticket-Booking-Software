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
import com.tgi.springAirlines.Entity.Company;
import com.tgi.springAirlines.Service.CompanyService;
import com.tgi.springAirlines.Service.FlightService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	CompanyService companyService;
	@RequestMapping(value="/getAllCompany",method = RequestMethod.GET)
	public List<Company>getAllCompany()throws Exception{
		return companyService.getAllCompany();
	}
	@RequestMapping(value="/createCompany",method = RequestMethod.POST)
	public ResponseEntity<?>createCompany(@RequestBody Company company)throws Exception{
		return companyService.createCompany(company);
	}
	@RequestMapping(value = "/getCompanyById/{id}", method = RequestMethod.GET)
	public ResponseEntity<?>getCompanyById(@PathVariable("id")Long id)throws Exception{
		return companyService.getCompanyById(id);
		
	}
	@RequestMapping(value="/updateCompany",method = RequestMethod.PUT)
	public ResponseEntity<?>updateCompany(@RequestBody Company company)throws Exception{
		return companyService.updateCompany(company);
	}
	

}
