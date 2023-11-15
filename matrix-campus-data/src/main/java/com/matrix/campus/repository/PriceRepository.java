package com.matrix.campus.repository;

import com.matrix.campus.entities.Price;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PriceRepository extends JpaRepository<Price, Long> {

  @Query("SELECT p FROM Price p WHERE p.product.productId = :productId AND p.brand.brandId = :brandId "
      + "AND :date BETWEEN p.startDate AND p.endDate")
  List<Price> findByProductIdAndBrandIdAndDate(Long productId, Long brandId, OffsetDateTime date);
}
