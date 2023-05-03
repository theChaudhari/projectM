package com.vap.projectM.service;

import com.vap.projectM.entity.User;
import com.vap.projectM.exception.ValidationException;

public interface IValidationService{
    public Boolean validateUser(User user) throws  ValidationException;
}
