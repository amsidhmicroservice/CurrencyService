package com.amsidh.mvc.currencyconversion.service.impl;

import com.amsidh.mvc.currencyconversion.service.InstanceInformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
        log.info("Inside retrieveInstanceInfo method of InstanceInformationService");
        return projectVersion + " : " + nodeName;
    }
}
