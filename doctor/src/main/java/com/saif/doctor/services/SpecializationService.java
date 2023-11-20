package com.saif.doctor.services;

import com.saif.shared.clients.doctor.SpecializationRequest;
import com.saif.doctor.models.Specialization;
import com.saif.shared.clients.doctor.SpecializationDto;

import java.util.List;

public interface SpecializationService {
  List<SpecializationDto> getAll();
  SpecializationDto getById(Long id);

  SpecializationDto create(SpecializationRequest request);
  SpecializationDto update(Long id, SpecializationRequest request);
  SpecializationDto toSpecializationDto(Specialization saved);
  void delete(Long id);
  public Specialization findOrThrow(Long id);
}
