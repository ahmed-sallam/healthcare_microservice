package com.saif.shared.clients.doctor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class  DoctorDto {
  private Long id;
  private String name;
  private SpecializationDto specialization;

}
