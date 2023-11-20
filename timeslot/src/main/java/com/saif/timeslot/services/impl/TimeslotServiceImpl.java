package com.saif.timeslot.services.impl;

import com.saif.shared.exceptions.NotFoundException;
import com.saif.timeslot.models.Timeslot;
import com.saif.shared.clients.timeslot.TimeslotDto;
import com.saif.shared.clients.timeslot.TimeslotRequest;
import com.saif.timeslot.repositories.TimeSlotRepository;
import com.saif.timeslot.services.TimeslotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TimeslotServiceImpl implements TimeslotService {
  private  final TimeSlotRepository repository;
  @Override
  public List<TimeslotDto> getAllByDoctorId(Long doctorId) {
    List<Timeslot> all = repository.findAllByDoctorId(doctorId);
    return all.stream().map(this::toTimeslotDto).collect(Collectors.toList());
  }

  @Override
  public TimeslotDto getById(Long id) {
    Timeslot timeslot = findOrThrow(id);
    return toTimeslotDto(timeslot);

  }

  @Override
  public TimeslotDto create(TimeslotRequest request) {
    Timeslot entity = Timeslot.builder()
        .dateTime(request.getDateTime())
        .doctorId(request.getDoctorId())
        .isAvailable(true)
        .build();
    Timeslot saved = repository.save(entity);
    return toTimeslotDto(saved);
  }

  @Override
  public TimeslotDto update(Long id, TimeslotRequest request) {
    Timeslot timeslot = findOrThrow(id);
    timeslot.setDateTime(request.getDateTime());
    timeslot.setIsAvailable(request.getIsAvailable());
    Timeslot saved = repository.save(timeslot);
    return toTimeslotDto(saved);
  }

  private TimeslotDto toTimeslotDto(Timeslot saved) {
    return new TimeslotDto(saved.getId(), saved.getDateTime(),  saved.getIsAvailable(), saved.getDoctorId());

  }

  @Override
  public void delete(Long id) {
    Timeslot timeslot = findOrThrow(id);
    if(timeslot.getIsAvailable()){
      repository.deleteById(id);

    }
// todo: handle timeslot is not available
  }

  public Timeslot findOrThrow(Long id) {
    return repository.findById(id)
        .orElseThrow(() ->
            new NotFoundException("Timeslot with id " + id + " not found"));
  }
}
