package com.saif.timeslot.controllers;

import com.saif.shared.clients.timeslot.TimeslotDto;
import com.saif.shared.clients.timeslot.TimeslotRequest;
import com.saif.timeslot.services.TimeslotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timeslots")
@RequiredArgsConstructor
public class TimeslotController {
  private final TimeslotService timeslotService;

  @GetMapping("/by-doctor/{id}")
  public ResponseEntity<List<TimeslotDto>> getAllByDoctorId(@PathVariable("id") Long id) {
    return new ResponseEntity<>(timeslotService.getAllByDoctorId(id), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TimeslotDto> getById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(timeslotService.getById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<TimeslotDto> create(@RequestBody TimeslotRequest request) {
    return new ResponseEntity<>(timeslotService.create(request), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<TimeslotDto> update(
      @PathVariable("id") Long id,
      @RequestBody TimeslotRequest request) {
    return new ResponseEntity<>(timeslotService.update(id, request), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable("id") Long id) {
    timeslotService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
