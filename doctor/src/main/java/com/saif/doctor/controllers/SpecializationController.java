package com.saif.doctor.controllers;

import com.saif.shared.clients.doctor.SpecializationRequest;
import com.saif.shared.clients.doctor.SpecializationDto;
import com.saif.doctor.services.SpecializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/doctors/specializations")
@RequiredArgsConstructor
public class SpecializationController {
  private final SpecializationService specializationService;

  @GetMapping
  public ResponseEntity<List<SpecializationDto>> getAll() {
    return new ResponseEntity<>(specializationService.getAll(), HttpStatus.OK);
  }
  @GetMapping("/{id}")
  public ResponseEntity<SpecializationDto> getById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(specializationService.getById(id), HttpStatus.OK);
  }


  @PostMapping
  public ResponseEntity<SpecializationDto> create(@RequestBody SpecializationRequest request) {
    return new ResponseEntity<>(specializationService.create(request), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<SpecializationDto> update(
      @PathVariable("id") Long id,
      @RequestBody SpecializationRequest request) {
    return new ResponseEntity<>(specializationService.update(id,request), HttpStatus.CREATED);

  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete( @PathVariable("id") Long id) {
    specializationService.delete(id);
    return new ResponseEntity<>( HttpStatus.NO_CONTENT);
  }


}
