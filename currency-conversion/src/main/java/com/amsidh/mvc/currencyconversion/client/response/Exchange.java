package com.amsidh.mvc.currencyconversion.client.response;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Exchange implements Serializable {

  private Long id;
  private String currencyFrom;
  private String currencyTo;
  private BigDecimal conversionMultiple;
  private String exchangeEnvironmentInfo;
}