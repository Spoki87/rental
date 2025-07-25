package com.rental.exception.base;

public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
