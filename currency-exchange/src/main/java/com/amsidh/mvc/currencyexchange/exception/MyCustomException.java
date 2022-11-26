package com.amsidh.mvc.currencyexchange.exception;

import java.io.Serializable;

public class MyCustomException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 271673332397719853L;

	public MyCustomException(String message) {
        super(message);
    }
}
