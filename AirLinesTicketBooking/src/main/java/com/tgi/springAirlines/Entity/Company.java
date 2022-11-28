package com.tgi.springAirlines.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "company")
@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "companyName")
	private String companyName;
	@Column(name = "emailAddress")
	private String emailAddress;
	@Column(name = "phoneNumber")
	private String phoneNumber;
	@Column(name = "status")
	private boolean status;

	public Company() {

	}

	public Company(Long id, String companyName, String emailAddress, String phoneNumber, boolean status) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
