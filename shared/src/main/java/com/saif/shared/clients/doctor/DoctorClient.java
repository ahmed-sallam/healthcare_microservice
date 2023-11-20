package com.saif.shared.clients.doctor;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( name = "doctor", path = "/api/doctors")
public interface DoctorClient {

  @GetMapping("/{id}")
  public DoctorDto getById(@PathVariable("id") Long id);
}
