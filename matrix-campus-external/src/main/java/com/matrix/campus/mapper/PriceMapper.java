package com.matrix.campus.mapper;

import com.matrix.campus.dto.response.PriceResponseDto;
import com.matrix.campus.entities.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceMapper {
  @Mapping(source = "fee.feeId", target = "feeId")
  @Mapping(source = "brand.brandId", target = "brandId")
  @Mapping(source = "product.productId", target = "productId")
  PriceResponseDto priceToPriceResponseDto(Price price);
}
