package com.saif.doctor.services.impl;

import com.saif.shared.clients.doctor.SpecializationRequest;
import com.saif.doctor.models.Specialization;
import com.saif.shared.clients.doctor.SpecializationDto;
import com.saif.doctor.repositories.SpecializationRepository;
import com.saif.doctor.services.SpecializationService;
import com.saif.shared.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpecializationServiceImpl implements SpecializationService {
  private final SpecializationRepository repository;

  @Override
  public List<SpecializationDto> getAll() {
    List<Specialization> all = repository.findAll();
    return all.stream().map(this::toSpecializationDto
    ).collect(Collectors.toList());
  }

  @Override
  public SpecializationDto getById(Long id) {
    Specialization specialization = findOrThrow(id);
    return toSpecializationDto(specialization);
  }

  @Override
  public SpecializationDto create(SpecializationRequest request) {
    // todo: check if name is already taken
    Specialization entity = Specialization
        .builder()
        .name(request.getName())
        .build();
    Specialization saved = repository.save(entity);
    return toSpecializationDto(saved);
  }

  @Override
  public SpecializationDto update(Long id, SpecializationRequest request) {
    // todo: check if name is already taken
    Specialization specialization = findOrThrow(id);
    specialization.setName(request.getName());
    Specialization saved = repository.save(specialization);
    return toSpecializationDto(saved);

  }
  @Override
  public SpecializationDto toSpecializationDto(Specialization saved) {
    return SpecializationDto
        .builder()
        .id(saved.getId())
        .name(saved.getName())
        .build();
  }

  @Override
  public void delete(Long id) {
    findOrThrow(id);
    repository.deleteById(id);
  }

  public Specialization findOrThrow(Long id) {
    return repository.findById(id)
        .orElseThrow(() ->
            new NotFoundException("Specialization with id " + id + " not found"));
  }
}
