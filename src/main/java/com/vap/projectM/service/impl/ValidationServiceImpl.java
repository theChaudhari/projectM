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
        boolean dobValidator = Pattern.matches("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$?", user.getDob());
        boolean panIdValidator = Pattern.matches("[a-zA-Z0-9]+\\.?", user.getPanId());

        String errorField = " ";
        if (!(firstNameValidator && lastNameValidator && phoneValidator)) {
            if (!firstNameValidator) {
                errorField = "FirstName, ";
            }
            if (!lastNameValidator) {
                errorField = errorField + "LastName, ";
            }
            if (!phoneValidator) {
                errorField = errorField + "Phone Number, ";
            }
            if (!dobValidator){
                errorField = errorField+ "Dob ";
            }
            if (!panIdValidator){
                errorField = errorField+"& Pan number";
            }
            throw new ValidationException("Error Occurred In " + errorField);
        }
        userRepository.save(user);
        log.info("Saving User " + user.getFirstName() + " To Database");
        return true;
    }


}
