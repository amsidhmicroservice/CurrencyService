package com.amsidh.mvc.currencyexchange.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Exchange")
public class Exchange {
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
