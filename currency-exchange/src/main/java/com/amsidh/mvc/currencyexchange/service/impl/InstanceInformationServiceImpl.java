package com.amsidh.mvc.currencyexchange.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amsidh.mvc.currencyexchange.exception.MyCustomException;
import com.amsidh.mvc.currencyexchange.service.InstanceInformationService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InstanceInformationServiceImpl implements InstanceInformationService {

    private static final String HOST_NAME = "HOSTNAME";

    @Value("${" + HOST_NAME + ":local}")
    private String nodeName;

    @Value("${info.app.version:NoVersion}")
    private String projectVersion;

    @Override
    public String retrieveInstanceInfo() {
        log.debug("Inside retrieveInstanceInfo method of InstanceInformationService in currency-exchange service " + projectVersion + " : " + nodeName);
        return projectVersion + " : " + nodeName;
    }

    @Override
    public String throwException() throws MyCustomException {
        MyCustomException myCustomException= new MyCustomException("Manually throwing exception");
        log.error("Error==>", myCustomException);
        throw myCustomException;
    }
}
