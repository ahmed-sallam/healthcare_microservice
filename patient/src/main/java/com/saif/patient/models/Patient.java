package com.saif.patient.models;


import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity(name = "Patient")
@Table(name = "patients")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Patient {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name="id", updatable = false)
  private Long id;
  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "contact_number", nullable = false)
  private String contactNumber;

}
