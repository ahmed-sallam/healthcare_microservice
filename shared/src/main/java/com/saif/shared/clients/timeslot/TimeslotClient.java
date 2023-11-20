package com.saif.shared.clients.timeslot;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "timeslot", path = "/api/timeslots")
public interface TimeslotClient {

  @GetMapping("/{id}")
  public TimeslotDto getById(@PathVariable("id") Long id);
  @PutMapping("/{id}")
  public TimeslotDto update(
      @PathVariable("id") Long id,
      @RequestBody TimeslotRequest request);
}
