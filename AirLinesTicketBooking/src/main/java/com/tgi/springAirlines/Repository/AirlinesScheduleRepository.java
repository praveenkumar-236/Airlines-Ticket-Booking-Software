package com.tgi.springAirlines.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tgi.springAirlines.Entity.AirlinesSchedule;
@Repository
public interface AirlinesScheduleRepository extends JpaRepository<AirlinesSchedule,Long> {

}
