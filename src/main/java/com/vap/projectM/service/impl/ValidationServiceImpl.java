package com.vap.projectM.service.impl;

import com.vap.projectM.entity.User;
import com.vap.projectM.exception.ValidationException;
import com.vap.projectM.repository.UserRepository;
import com.vap.projectM.service.ValidationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@Slf4j
@AllArgsConstructor
public class ValidationServiceImpl implements ValidationService {

    private final UserRepository userRepository;

    @Override
    public Boolean validateUser(User user) throws ValidationException {
        boolean firstNameValidator = Pattern.matches("[a-zA-Z]+\\.?", user.getFirstName());
        boolean lastNameValidator = Pattern.matches("[a-zA-Z]+\\.?", user.getLastName());
        boolean phoneValidator = Pattern.matches("[0-9]+\\.?", user.getPhone());
        if (!(firstNameValidator)) {
            log.info("Error in FirstName");
            throw new ValidationException("Error in FirstName");

        }
        if (!(lastNameValidator)) {
            log.info("Error in LastName");
            throw new ValidationException("Error in LastName");

        }
        if (!(phoneValidator)) {
            log.info("Error in Phone Number");
            throw new ValidationException("Error in Phone Number");
        }
        userRepository.save(user);
        return firstNameValidator && lastNameValidator && phoneValidator;
    }
}
