package com.saif.appointment.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentRequest {
  private Long doctorId;
  private Long patientId;
  private Long timeslotId;
}
