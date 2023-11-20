package com.saif.doctor.services.impl;

import com.saif.shared.clients.doctor.DoctorDto;
import com.saif.shared.clients.doctor.DoctorRequest;
import com.saif.doctor.models.Doctor;
import com.saif.doctor.models.Specialization;
import com.saif.doctor.repositories.DoctorRepository;
import com.saif.doctor.services.DoctorService;
import com.saif.doctor.services.SpecializationService;
import com.saif.shared.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
  private final DoctorRepository repository;
  private final SpecializationService specializationService;
  @Override
  public List<DoctorDto> getAll() {
    List<Doctor> all = repository.findAll();
    return all.stream()
        .map(this::toDoctorDto)
        .collect(Collectors.toList());
  }

  @Override
  public DoctorDto getById(Long id) {
    Doctor doctor = findOrThrow(id);
    return toDoctorDto(doctor);
  }

  @Override
  public DoctorDto create(DoctorRequest request) {
    Specialization sp = specializationService.findOrThrow(request.getSpecializationId());
    Doctor entity = Doctor.builder()
        .name(request.getName())
        .build();
    entity.setSpecialization(sp);
    Doctor saved = repository.save(entity);
    return  toDoctorDto(saved);
  }

  private DoctorDto toDoctorDto(Doctor saved) {
    return DoctorDto
          .builder()
          .id(saved.getId())
          .name(saved.getName())
          .specialization(specializationService.toSpecializationDto(saved.getSpecialization()))
          .build();
  }

  @Override
  public DoctorDto update(Long id, DoctorRequest request) {
    Doctor doctor = findOrThrow(id);
    doctor.setName(request.getName());
    Doctor saved = repository.save(doctor);
    return toDoctorDto(saved);
  }

  @Override
  public void delete(Long id) {
    findOrThrow(id);
    // todo: check if is there exists relations (time slots)
    repository.deleteById(id);

  }
  public Doctor findOrThrow(Long id) {
    return repository.findById(id)
        .orElseThrow(() ->
            new NotFoundException("Doctor with id " + id + " not found"));
  }
}
