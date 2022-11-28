package com.tgi.springAirlines.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tgi.springAirlines.Entity.Airlines;

@Repository
public interface AirlinesRepository extends JpaRepository<Airlines,Long>{

}
