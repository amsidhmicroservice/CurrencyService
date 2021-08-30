package com.amsidh.mvc.currencyexchange.controller;

import com.amsidh.mvc.currencyexchange.entity.Exchange;
import com.amsidh.mvc.currencyexchange.repository.ExchangeRepository;
import com.amsidh.mvc.currencyexchange.service.InstanceInformationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ExchangeController {
    private final ExchangeRepository exchangeRepository;
    private final InstanceInformationService instanceInformationService;

    @GetMapping("/")
    public String healthCheck() {
        log.info("healthCheck method of ExchangeController on host " + instanceInformationService.retrieveInstanceInfo());
        return "{status:up}";
    }

    //http://34.121.35.177:8181/currency-exchange/USD/to/INR
    @GetMapping(value = "/currency-exchange/{currencyFrom}/to/{currencyTo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Exchange getCurrencyExchange(@PathVariable("currencyFrom") String currencyFrom, @PathVariable("currencyTo") String currencyTo) {
        log.info("Inside getCurrencyExchange method of ExchangeRepository");
        Exchange exchange = exchangeRepository.findExchangeByCurrencyFromAndCurrencyTo(currencyFrom, currencyTo);
        exchange.setExchangeEnvironmentInfo(instanceInformationService.retrieveInstanceInfo());
        return exchange;
    }

}
