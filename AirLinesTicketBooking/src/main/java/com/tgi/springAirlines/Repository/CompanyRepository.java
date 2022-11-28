package com.tgi.springAirlines.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tgi.springAirlines.Entity.Company;
@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

}
