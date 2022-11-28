package com.tgi.springAirlines.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tgi.springAirlines.Entity.Flight;
@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

	Optional<Flight> findByflightName(String flightName);

}
