package com.amsidh.mvc.currencyexchange.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
