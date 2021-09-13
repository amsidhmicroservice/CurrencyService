package com.amsidh.mvc.currencyconversion.controller;

import com.amsidh.mvc.currencyconversion.client.response.Exchange;
import com.amsidh.mvc.currencyconversion.response.CurrencyConversionResponse;
import com.amsidh.mvc.currencyconversion.service.InstanceInformationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/currency-conversion")
public class ConversionController {

    private final RestTemplate restTemplate;
    private final InstanceInformationService instanceInformationService;

    @Value("${CURRENCY_EXCHANGE_URL:http://localhost:8181}")
    public String currencyExchangeUrl;

    @GetMapping("/")
    public String healthCheck() {
        //log.debug("healthCheck method of ConversionController on host " + instanceInformationService.retrieveInstanceInfo());
        return "{status:up}";
    }


    //http://35.222.88.162:8282/currency-conversion/from/USD/to/INR/quantity/100
    @GetMapping(value = {"/from/{currencyFrom}/to/{currencyTo}/quantity/{quantity}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public CurrencyConversionResponse convertCurrency(@PathVariable("currencyFrom") String currencyFrom, @PathVariable("currencyTo") String currencyTo, @PathVariable("quantity") BigDecimal quantity) {
        log.info("Inside convertCurrency method of ConversionController!!!");
        String currencyExchangeUrlFullPath = currencyExchangeUrl + "/currency-exchange/" + currencyFrom + "/to/" + currencyTo;
        log.info("Calling CurrencyExchange service with url " + currencyExchangeUrlFullPath);
        Exchange exchange = restTemplate.getForEntity(currencyExchangeUrlFullPath, Exchange.class).getBody();
        assert exchange != null;
        return CurrencyConversionResponse.builder()
                .id(exchange.getId())
                .from(exchange.getCurrencyFrom())
                .to(exchange.getCurrencyTo())
                .conversionMultiple(exchange.getConversionMultiple())
                .quantity(quantity)
                .conversionEnvironmentInfo(instanceInformationService.retrieveInstanceInfo())
                .exchangeEnvironmentInfo(exchange.getExchangeEnvironmentInfo())
                .totalCalculatedAmount(quantity.multiply(exchange.getConversionMultiple()))
                .build();
    }
}
