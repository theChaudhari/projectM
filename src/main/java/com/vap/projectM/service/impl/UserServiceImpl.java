package com.vap.projectM.service.impl;

import com.vap.projectM.entity.User;
import com.vap.projectM.exception.TechnicalException;
import com.vap.projectM.exception.ValidationException;
import com.vap.projectM.repository.UserRepository;
import com.vap.projectM.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public Boolean validateUser(User user) throws ValidationException {
        return validateUser(user);
    }

    public boolean isFirstNameExists(String firstName) {
        return userRepository.existsByFirstName(firstName);
    }

    public boolean isLastNaeExists(String lastName) {
        return userRepository.existsByLastName(lastName);
    }

    public boolean isDobExists(String dob) {
        return userRepository.existsByDob(dob);
    }

    public boolean isPhoneExists(String phone) {
        return userRepository.existsByPhone(phone);
    }

    public boolean isPanExists(String panId){return userRepository.existsByPanId(panId);}

    public boolean isCityExists(String city) {
        return userRepository.existsByCity(city);
    }

    @Override
    public String possibleMerge(User user) {

        if ((isFirstNameExists(user.getFirstName()) && isLastNaeExists(user.getLastName()) && isDobExists(user.getDob()) && isPhoneExists(user.getPhone())) || isCityExists(user.getCity())) {
            return "This User '" + user.getFirstName() + "' could be possible merge";
        }
        return "Not In DataBase";
    }

    @Override
    public String autoMerge(User user) throws TechnicalException {
        if(isPanExists(user.getPanId())){
            Optional<User> exUser = userRepository.findByPanId();
            if (exUser.isPresent()){
                User user1 = exUser.get();
                user1.setFirstName(user.getFirstName());
                user1.setLastName(user.getLastName());
                user1.setCity(user.getCity());
                user1.setPhone(user.getPhone());
                user1.setDob(user.getDob());
                userRepository.save(user1);

            }
            return "this ";
        }
        userRepository.save(user);
        return "New User "+ user.getFirstName()+" Is Added";
    }


}
