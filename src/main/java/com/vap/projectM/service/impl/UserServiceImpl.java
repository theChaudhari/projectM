package com.vap.projectM.service.impl;

import com.vap.projectM.entity.User;
import com.vap.projectM.exception.ValidationException;
import com.vap.projectM.repository.UserRepository;
import com.vap.projectM.service.IUserService;
import com.vap.projectM.service.IValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    private final IValidationService IValidationService;
    @Override
    public Boolean validateUser(User user) throws ValidationException {
        return IValidationService.validateUser(user);
    }
}
