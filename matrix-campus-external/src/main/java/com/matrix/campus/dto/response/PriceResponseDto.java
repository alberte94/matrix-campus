package com.matrix.campus.dto.response;

import static com.matrix.campus.application.ApplicationValues.OFFSET_DATE_TIME_FORMAT;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.OffsetDateTime;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PriceResponseDto implements Serializable {

  private Long productId;
  private Long brandId;
  private Long feeId;
  @JsonFormat(pattern = OFFSET_DATE_TIME_FORMAT)
  private OffsetDateTime startDate;
  @JsonFormat(pattern = OFFSET_DATE_TIME_FORMAT)
  private OffsetDateTime endDate;
  private Double pvp;
}
