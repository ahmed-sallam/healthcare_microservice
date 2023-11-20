package com.saif.doctor.models;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;


@Entity(name = "Doctor")
@Table(name = "doctors")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Doctor {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name="id", updatable = false)
  private Long id;
  @Column(name = "name", nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "specialization_id", nullable = false, referencedColumnName = "id", foreignKey =
  @ForeignKey(name = "DOCTOR_SPECIFICATION_ID_FK"))
  private Specialization specialization;
}
