package com.amsidh.mvc.controller;

import com.amsidh.mvc.model.CurrencyConversion;
import com.amsidh.mvc.model.CurrencyExchange;
import com.amsidh.mvc.service.InstanceInformationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.resilience4j.bulkhead.ThreadPoolBulkhead;
import io.github.resilience4j.bulkhead.ThreadPoolBulkheadRegistry;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Optional;

import static com.amsidh.mvc.common.Constant.CURRENCY_EXCHANGE_API_CALL_CIRCUIT_BREAKER;
import static com.amsidh.mvc.common.Constant.CURRENCY_EXCHANGE_API_CALL_RETRY;
import static io.github.resilience4j.decorators.Decorators.ofSupplier;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/currency-conversion")
public class ConversionController {

    private final RestTemplate restTemplate;
    private final InstanceInformationService instanceInformationService;
    private final RetryRegistry retryRegistry;
    private final CircuitBreakerRegistry circuitBreakerRegistry;
    private final ThreadPoolBulkheadRegistry threadPoolBulkheadRegistry;
    private final ObjectMapper objectMapper;

    @Value("${CURRENCY_EXCHANGE_URL:http://localhost:8181}")
    public String currencyExchangeUrl;

    //http://35.222.88.162:8282/currency-conversion/from/USD/to/INR/quantity/100
    @SneakyThrows
    @GetMapping(value = {"/from/{currencyFrom}/to/{currencyTo}/quantity/{quantity}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public CurrencyConversion convertCurrency(@PathVariable("currencyFrom") String currencyFrom, @PathVariable("currencyTo") String currencyTo, @PathVariable("quantity") BigDecimal quantity) {
        log.info("=======================================Start Request================================================");
        log.info("Inside convertCurrency method of ConversionController!!!");

        ResponseEntity<CurrencyExchange> responseEntity = getCurrencyExchangeResponseEntity(currencyFrom, currencyTo);
        CurrencyExchange exchange = responseEntity != null ? responseEntity.getBody() : CurrencyExchange.builder().build();
        log.info("Response received from currency-exchange service {}", objectMapper.writeValueAsString(exchange));
        CurrencyConversion.CurrencyConversionBuilder builder = CurrencyConversion.builder().from(currencyFrom).to(currencyTo).quantity(quantity).conversionEnvironmentInfo(instanceInformationService.retrieveInstanceInfo());
        builder = exchange != null ? builder.id(exchange.getId()).conversionMultiple(exchange.getConversionMultiple()).exchangeEnvironmentInfo(exchange.getExchangeEnvironmentInfo()).totalCalculatedAmount(quantity.multiply(exchange.getConversionMultiple() != null ? exchange.getConversionMultiple() : new BigDecimal(0))) : builder;
        log.info("=======================================End Request================================================");
        return builder.build();
    }

    @SneakyThrows
    private ResponseEntity<CurrencyExchange> getCurrencyExchangeResponseEntity(String currencyFrom, String currencyTo) {
        String currencyExchangeUrlFullPath = currencyExchangeUrl + "/currency-exchange/" + currencyFrom + "/to/" + currencyTo;
        log.info("Calling CurrencyExchange service with url " + currencyExchangeUrlFullPath);

        Retry retry = retryRegistry.retry(CURRENCY_EXCHANGE_API_CALL_RETRY);
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker(CURRENCY_EXCHANGE_API_CALL_CIRCUIT_BREAKER);
        ThreadPoolBulkhead threadPoolBulkhead = threadPoolBulkheadRegistry.bulkhead("currency-exchange-api-call-bulkhead");
        return ofSupplier(() -> restTemplate.getForEntity(currencyExchangeUrlFullPath, CurrencyExchange.class))
                .withCircuitBreaker(circuitBreaker)
                .withRetry(retry)
                .withThreadPoolBulkhead(threadPoolBulkhead)
                .withFallback((currencyExchangeResponseEntity, throwable) -> Optional.ofNullable(currencyExchangeResponseEntity).orElse(null))
                .decorate()
                .get().toCompletableFuture().get();

    }
}
