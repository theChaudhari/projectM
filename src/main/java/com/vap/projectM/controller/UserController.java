package com.vap.projectM.controller;

import com.vap.projectM.entity.User;
import com.vap.projectM.exception.ValidationException;
import com.vap.projectM.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
class UserController {

    private final UserService userService;
    @PostMapping("/validateUser")
    public Boolean validateUser  (@RequestBody User user) throws ValidationException {
        return userService.validateUser(user);
    }

}
