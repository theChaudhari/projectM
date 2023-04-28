package com.vap.projectM.service.impl;

import com.vap.projectM.entity.User;
import com.vap.projectM.repository.UserRepository;
import com.vap.projectM.service.UserService;
import com.vap.projectM.service.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ValidationService validationService;
    @Override
    public Boolean validateUser(User user) {
        return validationService.validateUser(user);
    }
}
