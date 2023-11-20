package com.saif.shared.clients.patient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "patient", path = "/api/patients")
public interface PatientClient {

  @GetMapping("/{id}")
  public PatientDto getById(@PathVariable("id") Long id);
}
