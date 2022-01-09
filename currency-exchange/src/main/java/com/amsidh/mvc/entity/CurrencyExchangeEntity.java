package com.amsidh.mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "Exchange")
public class CurrencyExchangeEntity {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String currencyFrom;

    @Column(nullable = false)
    private String currencyTo;

    @Column(nullable = false)
    private BigDecimal conversionMultiple;

    @Column
    private String exchangeEnvironmentInfo;


}
