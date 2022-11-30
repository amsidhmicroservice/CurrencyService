package com.amsidh.mvc.currencyexchange.exception;

public class MyCustomException extends RuntimeException {

	private static final long serialVersionUID = -4298545392246061118L;

	public MyCustomException(String message) {
        super(message);
    }
}
