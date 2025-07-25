package com.rental.exception.domain;

import com.rental.exception.base.BusinessException;

public class EmailAlreadyExistException extends BusinessException {
    public EmailAlreadyExistException() {
        super("Email already taken");
    }
}
