package com.matrix.campus.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder(toBuilder = true)
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Fee {
  @Id
  @Column(updatable = false, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long feeId;
  @Column(nullable = false)
  private String feeCode;
  @Column(nullable = false)
  private String feeName;
  private String feeDescription;
}
