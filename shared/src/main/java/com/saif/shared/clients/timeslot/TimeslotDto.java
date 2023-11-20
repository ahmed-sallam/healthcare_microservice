package com.saif.shared.clients.timeslot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TimeslotDto extends TimeslotRequest {

  private Long id;

  public TimeslotDto(Long id, LocalDateTime dateTime, Boolean isAvailable, Long doctorId) {
    super(dateTime, isAvailable, doctorId);
    this.id = id;
  }
//  private LocalDateTime dateTime;
//  private Boolean isAvailable;
//  private Long doctorId;

}
