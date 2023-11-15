package com.matrix.campus.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Builder(toBuilder = true)
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Product {

  @Id
  @Column(updatable = false, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long productId;
  @Column(nullable = false)
  private String productCode;
  @Column(nullable = false)
  private String productName;
  private String productDescription;
}
