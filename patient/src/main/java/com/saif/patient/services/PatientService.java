package com.saif.patient.services;

import com.saif.shared.clients.patient.PatientDto;
import com.saif.patient.models.dto.PatientRequest;

import java.util.List;

public interface PatientService {
  List<PatientDto> getAll();
  PatientDto getById(Long id);
  PatientDto create(PatientRequest request);
  PatientDto update(Long id, PatientRequest request);
  void delete(Long id);
}
