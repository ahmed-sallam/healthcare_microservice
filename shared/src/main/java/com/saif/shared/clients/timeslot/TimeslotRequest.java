package com.saif.shared.clients.timeslot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TimeslotRequest  {
  private LocalDateTime dateTime;
  private Boolean isAvailable;
  private Long doctorId;

}
