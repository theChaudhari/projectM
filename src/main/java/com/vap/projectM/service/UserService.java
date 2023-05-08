package com.vap.projectM.service;

import com.vap.projectM.entity.User;
import com.vap.projectM.exception.TechnicalException;
import com.vap.projectM.exception.ValidationException;

public interface UserService {

    public Boolean validateUser(User user) throws  ValidationException;
    public String possibleMerge(User user) throws TechnicalException;

}
