package com.matrix.campus.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Builder(toBuilder = true)
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Brand {

  @Id
  @Column(updatable = false, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long brandId;
  @Column(nullable = false)
  private String brandCode;
  @Column(nullable = false)
  private String brandName;
  private String brandDescription;
}
