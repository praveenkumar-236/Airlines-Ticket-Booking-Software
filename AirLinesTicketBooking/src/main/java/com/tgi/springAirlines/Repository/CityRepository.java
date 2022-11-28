package com.tgi.springAirlines.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tgi.springAirlines.Entity.City;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {

	Optional<City> findBycityName(String cityName);

	Optional<City> findBycityShortCode(String cityShortCode);

}
