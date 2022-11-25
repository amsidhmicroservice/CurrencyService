package com.amsidh.mvc.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = InstanceInformationServiceImpl.class)
public class InstanceInformationServiceTest {

    @Autowired
    InstanceInformationServiceImpl instanceInformationService;

    @Test
    public void retrieveInstanceInfoTest() {
        String instanceInfo = this.instanceInformationService.retrieveInstanceInfo();
        Assertions.assertNotNull(instanceInfo);
        Assertions.assertTrue(instanceInfo.contains("NoVersion : local"));
    }
}
