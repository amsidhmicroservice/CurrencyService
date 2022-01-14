package com.amsidh.mvc.controller;

import com.amsidh.mvc.entity.CurrencyExchangeEntity;
import com.amsidh.mvc.model.CurrencyExchange;
import com.amsidh.mvc.repository.ExchangeRepository;
import com.amsidh.mvc.service.InstanceInformationService;
import com.amsidh.mvc.util.ConvertorUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/currency-exchange")
public class ExchangeController {
    private final ExchangeRepository exchangeRepository;
    private final InstanceInformationService instanceInformationService;

    //http://34.121.35.177:8181/currency-exchange/USD/to/INR
    @GetMapping(value = "/{currencyFrom}/to/{currencyTo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public CurrencyExchange getCurrencyExchange(@PathVariable("currencyFrom") String currencyFrom, @PathVariable("currencyTo") String currencyTo) {
        log.info("=======Start Request=======");
        log.info("Inside getCurrencyExchange method of ExchangeRepository");
        CurrencyExchangeEntity currencyExchangeEntity = exchangeRepository.findExchangeByCurrencyFromAndCurrencyTo(currencyFrom, currencyTo);
        currencyExchangeEntity.setExchangeEnvironmentInfo(instanceInformationService.retrieveInstanceInfo());
        log.info("Returning the response from currency-conversion service");
        log.info("=======End Request=======");
        return ConvertorUtil.toExchangeDTO(currencyExchangeEntity);
    }

    @GetMapping(value = "/message/{records}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> throwException(@PathVariable(name = "records") Integer records) {
        log.info("Sample Big Message {}", getMessage(records));
        RuntimeException runtimeException = new RuntimeException("Manually exception");
        log.error("Explicit exception thrown",runtimeException);
        return ResponseEntity.ok("This message won't return to the caller as it throws exception in the service method call");
    }

    private String getMessage(Integer records) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < records; i++) {
            sb.append(i).append(" : Researchers from the University of Bristol developed apparatus that generate tiny virus-containing particles and gently levitate them between two electric rings for anywhere between five seconds to 20 minutes, while controlling the surrounding temperature, humidity and UV light intensity.\n");
        }
        return sb.toString();
    }
}
