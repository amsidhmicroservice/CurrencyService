package com.amsidh.mvc.currencyconversion.client.feign;

import com.amsidh.mvc.currencyconversion.client.response.Exchange;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeFeignClient {
    @GetMapping(path = "/currency-exchange/{currencyFrom}/to/{currencyTo}")
    Exchange getCurrencyExchangeForFromAndTo(@PathVariable("currencyFrom") String currencyFrom, @PathVariable("currencyTo") String currencyTo);
}
