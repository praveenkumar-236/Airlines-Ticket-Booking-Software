package com.tgi.springAirlines.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgi.springAirlines.Entity.Company;
import com.tgi.springAirlines.Exception.ResourceNotFoundException;
import com.tgi.springAirlines.Exception.handleFoundException;
import com.tgi.springAirlines.Repository.CompanyRepository;
import com.tgi.springAirlines.Utility.ValidatorUtil;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	CompanyRepository companyRepository;

	@Override
	public List<Company> getAllCompany() throws Exception {
		try {
			List<Company> company = companyRepository.findAll();
			return company;
		} catch (Exception e) {

			throw new handleFoundException("something went wrong:" + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> createCompany(Company company) throws Exception {

		try {

			boolean phonevalid = ValidatorUtil.PhoneNumberIsValid(company.getPhoneNumber());
			if (phonevalid) {
				System.out.println(phonevalid + " " + "phonenumbervalid");
			} else {
				System.out.println(phonevalid + " " + "phonenumberinvalid");
				Map<String, Object> response = new HashMap<>();
				response.put("messgee", "phonenumberis invalid");
				response.put("ErrorCode", HttpStatus.BAD_REQUEST);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
			boolean valid = ValidatorUtil.EmailIsValid(company.getEmailAddress());
			if (valid) {
				System.out.println(valid + " " + " Email id valid");

			} else {
				System.out.println(valid + " " + " Email id is not valid");
				Map<String, Object> response = new HashMap<>();
				response.put("messgee", "Invalid emailid");
				response.put("ErrorCode", HttpStatus.BAD_REQUEST);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}

			company = companyRepository.save(company);

			return new ResponseEntity(company, HttpStatus.OK);
		} catch (Exception e) {

			throw new handleFoundException("something went wrong:" + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> getCompanyById(Long id) throws Exception {
		try {
			Company company = companyRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Country id not found :" + id));
			return new ResponseEntity(company, HttpStatus.OK);
		} catch (Exception e) {

			throw new handleFoundException("something went wrong:" + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> updateCompany(Company company) throws Exception {
		try {
			boolean phonevalid = ValidatorUtil.PhoneNumberIsValid(company.getPhoneNumber());
			if (phonevalid) {
				System.out.println(phonevalid + " " + "phonenumbervalid");
			} else {
				System.out.println(phonevalid + " " + "phonenumberinvalid");
				Map<String, Object> response = new HashMap<>();
				response.put("messgee", "phonenumberis invalid");
				response.put("ErrorCode", HttpStatus.BAD_REQUEST);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
			boolean valid = ValidatorUtil.EmailIsValid(company.getEmailAddress());
			if (valid) {
				System.out.println(valid + " " + " Email id valid");

			} else {
				System.out.println(valid + " " + " Email id is not valid");
				Map<String, Object> response = new HashMap<>();
				response.put("messgee", "Invalid emailid");
				response.put("ErrorCode", HttpStatus.BAD_REQUEST);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}

			company = companyRepository.save(company);
			return new ResponseEntity(company, HttpStatus.OK);
		} catch (Exception e) {

			throw new handleFoundException("something went wrong:" + e.getMessage());
		}
	}

}
