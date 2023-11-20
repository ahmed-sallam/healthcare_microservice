package com.saif.doctor.controllers;

import com.saif.shared.clients.doctor.DoctorDto;
import com.saif.shared.clients.doctor.DoctorRequest;
import com.saif.doctor.services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {
  private final DoctorService doctorService;

  @GetMapping
  public ResponseEntity<List<DoctorDto>> getAll() {
    return new ResponseEntity<>(doctorService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<DoctorDto> getById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(doctorService.getById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<DoctorDto> create(@RequestBody DoctorRequest request) {
    return new ResponseEntity<>(doctorService.create(request), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<DoctorDto> update(
      @PathVariable("id") Long id,
      @RequestBody DoctorRequest request) {
    return new ResponseEntity<>(doctorService.update(id, request), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable("id") Long id) {
    doctorService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
