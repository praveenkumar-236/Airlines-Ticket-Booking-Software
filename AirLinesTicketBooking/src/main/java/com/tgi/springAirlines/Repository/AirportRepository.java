package com.tgi.springAirlines.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tgi.springAirlines.Entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Long> {

	List<Airport> findByairportName(String airportName);

	Optional<Airport> findByairportShortCode(String airportShortCode);

}
