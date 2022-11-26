
package com.amsidh.mvc.currencyexchange;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amsidh.mvc.currencyexchange.controller.ExchangeController;

@SpringBootTest
class CurrencyExchangeApplicationTests {

    @Autowired
    ExchangeController exchangeController;

    @Test
    void contextLoads() {
        CurrencyExchangeApplication.main(new String[]{});
        Assertions.assertNotNull(exchangeController);
    }

}

