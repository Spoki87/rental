package com.rental.exception.domain;

import com.rental.exception.base.BusinessException;

public class ResourceNotFoundException extends BusinessException {
    public ResourceNotFoundException(Class<?> resourceClass, Object resourceId) {
        super(resourceClass.getSimpleName() + " with value " + resourceId + " not found.");
    }
}
