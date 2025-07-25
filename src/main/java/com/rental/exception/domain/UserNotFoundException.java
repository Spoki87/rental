package com.rental.exception.domain;

import com.rental.exception.base.BusinessException;

public class UserNotFoundException extends BusinessException {
    public UserNotFoundException() {
        super("User not found");
    }
}
