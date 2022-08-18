
package com.amsidh.mvc.currencyexchange;

import com.amsidh.mvc.currencyexchange.controller.ExchangeController;
import com.amsidh.mvc.currencyexchange.repository.ExchangeRepository;
import com.amsidh.mvc.currencyexchange.service.InstanceInformationService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@SpringBootTest
class CurrencyExchangeApplicationTests {

    private final ExchangeController exchangeController;
    private final InstanceInformationService instanceInformationService;
    private final ExchangeRepository exchangeRepository;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(exchangeController);
        Assertions.assertNotNull(instanceInformationService);
        Assertions.assertNotNull(exchangeRepository);
    }

}

