package com.saif.appointment.models.dto;

import com.saif.shared.clients.doctor.DoctorDto;
import com.saif.shared.clients.patient.PatientDto;
import com.saif.shared.clients.timeslot.TimeslotDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AppointmentDto {
  private Long id;
  private DoctorDto doctor;
  private PatientDto patient;
  private TimeslotDto timeslot;
}
