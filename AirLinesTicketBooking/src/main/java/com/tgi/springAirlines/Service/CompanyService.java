package com.tgi.springAirlines.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.tgi.springAirlines.Entity.Company;

public interface CompanyService {

	List<Company> getAllCompany()throws Exception;

	ResponseEntity<?> createCompany(Company company)throws Exception;

	ResponseEntity<?> getCompanyById(Long id)throws Exception;

	ResponseEntity<?> updateCompany(Company company)throws Exception;



	

}
