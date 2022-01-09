package com.amsidh.mvc.service;

import com.amsidh.mvc.exception.MyCustomException;

public interface InstanceInformationService {
    String retrieveInstanceInfo();
    String throwException() throws MyCustomException;
}
