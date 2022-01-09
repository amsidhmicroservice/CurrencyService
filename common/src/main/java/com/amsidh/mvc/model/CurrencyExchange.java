package com.amsidh.mvc.model;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyExchange implements Serializable {
    private Long id;
    private String currencyFrom;
    private String currencyTo;
    private BigDecimal conversionMultiple;
    private String exchangeEnvironmentInfo;
}
