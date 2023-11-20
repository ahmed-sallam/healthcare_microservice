package com.saif.appointment.services;

import com.saif.appointment.models.dto.AppointmentDto;
import com.saif.appointment.models.dto.AppointmentRequest;

import java.util.List;

public interface AppointmentService {
  List<AppointmentDto> findAllByDoctorId(Long doctorId);
  List<AppointmentDto> findAllByPatientId(Long patientId);
  AppointmentDto getById(Long id);
  AppointmentDto create(AppointmentRequest request);
  void delete(Long id);
}
