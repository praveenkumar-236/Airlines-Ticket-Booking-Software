package com.tgi.springAirlines.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tgi.springAirlines.Entity.State;

@Repository
public interface StateRepository extends JpaRepository<State,Long> {

	Optional<State> findByStateName(String stateName);

	Optional<State> findBystateShortCode(String stateShortCode);

}
