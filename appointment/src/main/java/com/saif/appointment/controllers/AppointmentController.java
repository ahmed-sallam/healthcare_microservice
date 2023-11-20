package com.saif.appointment.controllers;

import com.saif.appointment.models.dto.AppointmentDto;
import com.saif.appointment.models.dto.AppointmentRequest;
import com.saif.appointment.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {
  private final AppointmentService appointmentService;

  @GetMapping("/by-doctor/{id}")
  public ResponseEntity<List<AppointmentDto>> findAllByDoctorId(@PathVariable("id") Long id){
    return new ResponseEntity<>(appointmentService.findAllByDoctorId(id), HttpStatus.OK);
  }

  @GetMapping("/by-patient/{id}")
  public ResponseEntity<List<AppointmentDto>> findAllByPatientId(@PathVariable("id") Long id){
    return new ResponseEntity<>(appointmentService.findAllByPatientId(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<AppointmentDto> create(@RequestBody AppointmentRequest request){
    return new ResponseEntity<>(appointmentService.create(request), HttpStatus.CREATED);
  }
  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable("id") Long id) {
    appointmentService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
