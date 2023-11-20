package com.saif.patient.models.dto;

import com.saif.patient.models.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientRequest {
  private String name;
  private String contactNumber;

  public static Patient toEntity(PatientRequest dto) {
    return Patient.builder()
        .name(dto.getName())
        .contactNumber(dto.getContactNumber())
        .build();
  }
}
