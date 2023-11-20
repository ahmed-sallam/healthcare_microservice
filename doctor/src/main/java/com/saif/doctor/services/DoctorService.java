package com.saif.doctor.services;

import com.saif.shared.clients.doctor.DoctorDto;
import com.saif.shared.clients.doctor.DoctorRequest;

import java.util.List;

public interface DoctorService {
  List<DoctorDto> getAll();
  DoctorDto getById(Long id);
  DoctorDto create(DoctorRequest request);
  DoctorDto update(Long id, DoctorRequest request);
  void delete(Long id);
}
