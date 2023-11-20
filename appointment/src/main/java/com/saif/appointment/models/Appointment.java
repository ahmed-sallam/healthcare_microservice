package com.saif.appointment.models;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity(name = "Appointment")
@Table(name = "appointments",
    indexes = {
        @Index(name = "idx_appointment_doctor_id", columnList = "doctor_id"),
        @Index(name = "idx_appointment_patient_id", columnList = "patient_id")
    }
)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Appointment {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name="id", updatable = false)
  private Long id;
  @Column(name="doctor_id", nullable = false)
  private Long doctorId;
  @Column(name="patient_id", nullable = false)
  private Long patientId;
  @Column(name="timeslot_id", nullable = false)
  private Long timeslotId;
}
