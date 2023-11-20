package com.saif.appointment.repositories;

import com.saif.appointment.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

  List<Appointment> findAllByDoctorId(Long doctorId);
  List<Appointment> findAllByPatientId(Long patientId);

}
