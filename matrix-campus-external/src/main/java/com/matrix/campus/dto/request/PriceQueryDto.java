package com.matrix.campus.dto.request;

import static com.matrix.campus.application.ApplicationValues.OFFSET_DATE_TIME_FORMAT;
import static com.matrix.campus.application.ControllerMessages.FIELD_CANT_BE_NULL;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.OffsetTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.OffsetDateTime;
import lombok.*;

@Builder
@Getter
public class PriceQueryDto implements Serializable {
  @NotNull(message = FIELD_CANT_BE_NULL)
  @JsonFormat(pattern = OFFSET_DATE_TIME_FORMAT)
  @JsonDeserialize(using = OffsetTimeDeserializer.class)
  @JsonSerialize(using = OffsetDateTimeSerializer.class)
  private OffsetDateTime applicationDate;
  @NotNull(message = FIELD_CANT_BE_NULL)
  private Long productId;
  @NotNull(message = FIELD_CANT_BE_NULL)
  private Long brandId;
}
