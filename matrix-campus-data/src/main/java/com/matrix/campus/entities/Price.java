package com.matrix.campus.entities;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
public class Price {
  @Id
  @Column(updatable = false, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long priceId;
  @ManyToOne
  @JoinColumn(nullable = false, name = "brand_id")
  private Brand brand;
  @Column(nullable = false)
  private OffsetDateTime startDate;
  @Column(nullable = false)
  private OffsetDateTime endDate;
  @ManyToOne
  @JoinColumn(nullable = false, name = "fee_id")
  private Fee fee;
  @ManyToOne
  @JoinColumn(nullable = false, name = "product_id")
  private Product product;
  @Column(nullable = false)
  private Long priority;
  @Column(nullable = false)
  private Double pvp;
  @Column(nullable = false)
  private String currency;
}
