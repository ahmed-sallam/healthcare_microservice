package com.saif.timeslot.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity(name = "Timeslot")
@Table(name = "timeslots", indexes = {
    @Index(name = "idx_timeslot_doctor_id", columnList = "doctor_id")
})
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Timeslot {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name="id", updatable = false)
  private Long id;
  @Column(name = "date_time", nullable = false)
  private LocalDateTime dateTime;
  @Column(name="is_available", nullable = false, columnDefinition = "TINYINT")
  private Boolean isAvailable = true;
  @Column(name = "doctor_id", nullable = false)
  private Long doctorId;
}
