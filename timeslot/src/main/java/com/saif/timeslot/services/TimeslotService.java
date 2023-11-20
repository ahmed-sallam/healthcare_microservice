package com.saif.timeslot.services;

import com.saif.shared.clients.timeslot.TimeslotDto;
import com.saif.shared.clients.timeslot.TimeslotRequest;

import java.util.List;

public interface TimeslotService {
  List<TimeslotDto> getAllByDoctorId(Long doctorId);
  TimeslotDto getById(Long id);
  TimeslotDto create(TimeslotRequest request);
  TimeslotDto update(Long id, TimeslotRequest request);
  void delete(Long id);
}
