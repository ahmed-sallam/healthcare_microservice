package com.saif.appointment.services.impl;

import com.saif.appointment.models.Appointment;
import com.saif.appointment.models.dto.AppointmentDto;
import com.saif.appointment.models.dto.AppointmentRequest;
import com.saif.appointment.repositories.AppointmentRepository;
import com.saif.appointment.services.AppointmentService;
import com.saif.shared.clients.doctor.DoctorClient;
import com.saif.shared.clients.doctor.DoctorDto;
import com.saif.shared.clients.patient.PatientClient;
import com.saif.shared.clients.patient.PatientDto;
import com.saif.shared.clients.timeslot.TimeslotClient;
import com.saif.shared.clients.timeslot.TimeslotDto;
import com.saif.shared.exceptions.ConflictException;
import com.saif.shared.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
  private final AppointmentRepository repository;
  private final DoctorClient doctorClient;
  private final PatientClient patientClient;
  private final TimeslotClient timeslotClient;

  @Override
  public List<AppointmentDto> findAllByDoctorId(Long doctorId) {
    // todo:optimize the db queries

    List<Appointment> allByDoctorId = repository.findAllByDoctorId(doctorId);
    DoctorDto doctorDto = doctorClient.getById(doctorId);
    List<AppointmentDto> list = allByDoctorId.stream().map(i ->
        {
          PatientDto patientDto = patientClient.getById(i.getPatientId());
          TimeslotDto timeslotDto = timeslotClient.getById(i.getTimeslotId());
          return toAppointmentDto(i.getId(), doctorDto, patientDto, timeslotDto);
        }
    ).collect(Collectors.toList());
    return list;
  }

  @Override
  public List<AppointmentDto> findAllByPatientId(Long patientId) {
    // todo:optimize the db queries

    List<Appointment> allByPatientId = repository.findAllByDoctorId(patientId);
    PatientDto patientDto = patientClient.getById(patientId);
    List<AppointmentDto> list = allByPatientId.stream().map(i ->
        {
          DoctorDto doctorDto = doctorClient.getById(i.getPatientId());
          TimeslotDto timeslotDto = timeslotClient.getById(i.getTimeslotId());
          return toAppointmentDto(i.getId(), doctorDto, patientDto, timeslotDto);
        }
    ).collect(Collectors.toList());
    return list;
  }

  @Override
  public AppointmentDto getById(Long id) {
    // todo: implement
    return null;
  }

  @Override
  public AppointmentDto create(AppointmentRequest request) {
    // todo:optimize the db queries
    TimeslotDto timeslotDto = timeslotClient.getById(request.getTimeslotId());
    if (!timeslotDto.getIsAvailable())
      throw new ConflictException("Timeslot is not available");
    DoctorDto doctorDto = doctorClient.getById(request.getDoctorId());
    PatientDto patientDto = patientClient.getById(request.getPatientId());
    timeslotDto.setIsAvailable(false);
    timeslotClient.update(timeslotDto.getId(),
        timeslotDto);
    Appointment appointmentEntity = toAppointmentEntity(request);
    Appointment saved = repository.save(appointmentEntity);
    return toAppointmentDto(saved.getId(), doctorDto, patientDto, timeslotDto);
  }

  private AppointmentDto toAppointmentDto(Long id, DoctorDto doctorDto, PatientDto patientDto,
                                          TimeslotDto timeslotDto) {
    return AppointmentDto
        .builder()
        .id(id)
        .doctor(doctorDto)
        .patient(patientDto)
        .timeslot(timeslotDto)
        .build();
  }

  private Appointment toAppointmentEntity(AppointmentRequest request) {
    return Appointment
        .builder()
        .doctorId(request.getDoctorId())
        .patientId(request.getPatientId())
        .timeslotId(request.getTimeslotId())
        .build();
  }

  @Override
  public void delete(Long id) {
    Appointment appointment = findOrThrow(id);
    TimeslotDto timeslotDto = timeslotClient.getById(appointment.getTimeslotId());
    timeslotDto.setIsAvailable(true);
    repository.deleteById(id);
    timeslotClient.update(timeslotDto.getId(),
        timeslotDto);
  }
  public Appointment findOrThrow(Long id) {
    return repository.findById(id)
        .orElseThrow(() ->
            new NotFoundException("Appointment with id " + id + " not found"));
  }
}
