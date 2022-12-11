package com.amsidh.mvc.currencyconversion.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
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
