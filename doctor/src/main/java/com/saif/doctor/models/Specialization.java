package com.saif.doctor.models;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;


@Entity(name = "Specialization")
@Table(name = "specializations")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Specialization {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;
  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @OneToMany()
  private List<Doctor> doctors = new ArrayList<Doctor>();
}
