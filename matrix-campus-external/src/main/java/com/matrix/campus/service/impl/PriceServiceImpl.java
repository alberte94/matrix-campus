package com.matrix.campus.service.impl;

import static com.matrix.campus.application.ControllerMessages.*;
import static com.matrix.campus.application.LoggerMessages.ERROR_MAX_PRIORITY_IS_NULL;

import com.matrix.campus.dto.response.PriceResponseDto;
import com.matrix.campus.entities.Price;
import com.matrix.campus.exception.NoDataException;
import com.matrix.campus.exception.TooManyDataException;
import com.matrix.campus.exception.UnexpectedErrorException;
import com.matrix.campus.mapper.PriceMapper;
import com.matrix.campus.repository.PriceRepository;
import com.matrix.campus.service.api.PriceService;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

  @NonNull
  private PriceRepository priceRepository;

  @NonNull
  private PriceMapper priceMapper;

  public PriceResponseDto getPrices(Long productId, Long brandId, OffsetDateTime date)
      throws NoDataException, TooManyDataException, UnexpectedErrorException {
    return priceMapper.priceToPriceResponseDto(getMaxPriorityPrice(
        priceRepository.findByProductIdAndBrandIdAndDate(productId, brandId, date)));
  }

  private Price validatePrice(List<Price> prices) {
    return switch (prices.size()) {
      case 0 -> throw new NoDataException(NOT_PRICE_FOUND);
      case 1 -> prices.get(0);
      default -> throw new TooManyDataException(ERROR_TOO_MANY_PRICES);
    };
  }

  private Price getMaxPriorityPrice(List<Price> prices) throws NoDataException, TooManyDataException {
    return validatePrice(prices.stream()
        .filter(price -> price.getPriority().equals(getMaxPriorityOfPrices(prices)))
        .toList());
  }

  private Long getMaxPriorityOfPrices(List<Price> prices) throws UnexpectedErrorException {
    return prices.stream()
        .mapToLong(Price::getPriority)
        .max()
        .orElseThrow(() -> new UnexpectedErrorException(SERVER_ERROR, ERROR_MAX_PRIORITY_IS_NULL));
  }
}
