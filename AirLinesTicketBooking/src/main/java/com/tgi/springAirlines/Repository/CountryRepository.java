package com.tgi.springAirlines.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tgi.springAirlines.Entity.Country;
@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {

	

	Optional<Country> findBycountryName(String countryName);

	Optional<Country> findBycountryShortCode(String countryShortCode);

}
