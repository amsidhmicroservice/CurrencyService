package com.amsidh.mvc.currencyconversion.response;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class CurrencyConversionResponse {

  private Long id;

  private String from;

  private String to;

  private BigDecimal conversionMultiple;

  private BigDecimal quantity;

  private BigDecimal totalCalculatedAmount;

  private String exchangeEnvironmentInfo;

  private String conversionEnvironmentInfo;
}
