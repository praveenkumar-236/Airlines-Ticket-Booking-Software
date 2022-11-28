package com.tgi.springAirlines.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tgi.springAirlines.Entity.Continent;

@Repository
public interface ContinentRepository extends JpaRepository<Continent,Long> {






	Optional<Continent> findBycontinentName(String continentName);

	Optional<Continent> findBycontinentShortCode(String continentShortCode);



	


	

}
