package com.saif.timeslot.repositories;

import com.saif.timeslot.models.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeSlotRepository extends JpaRepository<Timeslot, Long> {
  List<Timeslot> findAllByDoctorId(Long doctorId);
}
