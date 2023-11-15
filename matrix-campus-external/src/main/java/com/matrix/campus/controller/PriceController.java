package com.matrix.campus.controller;

import com.matrix.campus.dto.request.PriceQueryDto;
import com.matrix.campus.dto.response.PriceResponseDto;
import com.matrix.campus.exception.NoDataException;
import com.matrix.campus.exception.TooManyDataException;
import com.matrix.campus.exception.UnexpectedErrorException;
import com.matrix.campus.service.impl.PriceServiceImpl;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prices")
public class PriceController {

  @NonNull
  private PriceServiceImpl priceService;

  @GetMapping
  public @ResponseBody ResponseEntity<PriceResponseDto> getPrice(@Valid PriceQueryDto priceQueryDto)
      throws NoDataException, TooManyDataException, UnexpectedErrorException {
    return new ResponseEntity<>(priceService.getPrices(
        priceQueryDto.getProductId(), priceQueryDto.getBrandId(), priceQueryDto.getApplicationDate()),
        HttpStatus.OK);
  }
}
