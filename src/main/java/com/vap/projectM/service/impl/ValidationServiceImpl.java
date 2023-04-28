package com.vap.projectM.service.impl;

import com.vap.projectM.entity.User;
import com.vap.projectM.service.ValidationService;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Override
    public Boolean validateUser(User user) {
        boolean firstNameValidator = Pattern.matches("[a-zA-Z]+\\.?", user.getFirstName());
        boolean lastNameValidator = Pattern.matches("[a-zA-Z]+\\.?", user.getLastName());
        boolean phoneValidator = Pattern.matches("[0-9]+\\.?", user.getPhone());

        return firstNameValidator && lastNameValidator && phoneValidator;
    }
}
