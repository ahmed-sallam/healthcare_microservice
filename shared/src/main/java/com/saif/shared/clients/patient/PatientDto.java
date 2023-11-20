package com.saif.shared.clients.patient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PatientDto {
  private Long id;
  private String name;
  private String contactNumber;

}
