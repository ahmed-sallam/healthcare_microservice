package com.saif.patient.controllers;

import com.saif.shared.clients.patient.PatientDto;
import com.saif.patient.models.dto.PatientRequest;
import com.saif.patient.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {
  private final PatientService patientService;


  @GetMapping
  public ResponseEntity<List<PatientDto>> getAll() {
    return new ResponseEntity<>(patientService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PatientDto> getById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(patientService.getById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<PatientDto> create(@RequestBody PatientRequest request) {
    return new ResponseEntity<>(patientService.create(request), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<PatientDto> update(
      @PathVariable("id") Long id,
      @RequestBody PatientRequest request) {
    return new ResponseEntity<>(patientService.update(id, request), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable("id") Long id) {
    patientService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
