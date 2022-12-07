package com.amsidh.mvc.currencyconversion.client.response;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Exchange implements Serializable {
	private static final long serialVersionUID = -1305554216968338247L;
	private Long id;
    private String currencyFrom;
    private String currencyTo;
    private BigDecimal conversionMultiple;
    private String exchangeEnvironmentInfo;
}