package com.matrix.campus.service.api;

import com.matrix.campus.dto.response.PriceResponseDto;
import com.matrix.campus.exception.NoDataException;
import com.matrix.campus.exception.TooManyDataException;
import com.matrix.campus.exception.UnexpectedErrorException;
import java.time.OffsetDateTime;

public interface PriceService {
  PriceResponseDto getPrices(Long productId, Long brandId, OffsetDateTime date)
      throws NoDataException, TooManyDataException, UnexpectedErrorException;
}
