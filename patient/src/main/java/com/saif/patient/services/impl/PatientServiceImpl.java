package com.saif.patient.services.impl;

import com.saif.patient.models.Patient;
import com.saif.patient.models.dto.PatientRequest;
import com.saif.patient.repositories.PatientRepository;
import com.saif.patient.services.PatientService;
import com.saif.shared.clients.patient.PatientDto;
import com.saif.shared.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
  private final PatientRepository repository;

  @Override
  public List<PatientDto> getAll() {
    List<Patient> all = repository.findAll();
    return all.stream()
        .map(this::toPatientDto)
        .collect(Collectors.toList());
  }

  @Override
  public PatientDto getById(Long id) {
    Patient patient = findOrThrow(id);
    return toPatientDto(patient);
  }

  @Override
  public PatientDto create(PatientRequest request) {
    Patient entity = PatientRequest.toEntity(request);
    Patient saved = repository.save(entity);
    return toPatientDto(saved);
  }

  @Override
  public PatientDto update(Long id, PatientRequest request) {
    Patient patient = findOrThrow(id);
    patient.setName(request.getName());
    patient.setContactNumber(request.getContactNumber());
    Patient saved = repository.save(patient);
    return toPatientDto(saved);
  }

  private PatientDto toPatientDto(Patient saved) {
    return PatientDto
        .builder()
        .id(saved.getId())
        .name(saved.getName())
        .contactNumber(saved.getContactNumber())
        .build();
  }

  @Override
  public void delete(Long id) {
    findOrThrow(id);
    repository.deleteById(id);
  }

  public Patient findOrThrow(Long id) {
    return repository.findById(id)
        .orElseThrow(() ->
            new NotFoundException("Patient with id " + id + " not found"));
  }
}
