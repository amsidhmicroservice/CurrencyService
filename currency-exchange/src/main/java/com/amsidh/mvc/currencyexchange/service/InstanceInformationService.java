package com.amsidh.mvc.currencyexchange.service;

import com.amsidh.mvc.currencyexchange.exception.MyCustomException;

public interface InstanceInformationService {
    String retrieveInstanceInfo();
    String throwException() throws MyCustomException;
}
