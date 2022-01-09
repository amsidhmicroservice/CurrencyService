package com.amsidh.mvc.util;

import com.amsidh.mvc.entity.CurrencyExchangeEntity;
import com.amsidh.mvc.model.CurrencyExchange;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;

public class ConvertorUtil {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static CurrencyExchangeEntity toExchange(@NotNull CurrencyExchange currencyExchangeDTO) {
        return modelMapper.map(currencyExchangeDTO, CurrencyExchangeEntity.class);
    }

    public static CurrencyExchange toExchangeDTO(@NotNull CurrencyExchangeEntity currencyExchangeEntity) {
        return modelMapper.map(currencyExchangeEntity, CurrencyExchange.class);
    }

}
