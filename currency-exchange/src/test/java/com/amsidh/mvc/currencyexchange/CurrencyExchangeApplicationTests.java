
package com.amsidh.mvc.currencyexchange;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.amsidh.mvc.currencyexchange.controller.ExchangeController;
import com.amsidh.mvc.service.InstanceInformationService;

import lombok.RequiredArgsConstructor;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@ActiveProfiles("test")
class CurrencyExchangeApplicationTests {

    private final ExchangeController exchangeController;
    private final InstanceInformationService instanceInformationService;

    @Test
    void contextLoads() {
        CurrencyExchangeApplication.main(new String[]{});
        assertNotNull(exchangeController);
        Assertions.assertNotNull(instanceInformationService);
    }

}

