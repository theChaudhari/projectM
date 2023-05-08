package com.vap.projectM.controller;

import com.vap.projectM.entity.User;
import com.vap.projectM.exception.TechnicalException;
import com.vap.projectM.exception.ValidationException;
import com.vap.projectM.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
class UserController {

    private final UserService userService;
    @PostMapping("/validateUser")
    public String validateUser(@RequestBody User user) throws ValidationException {
        userService.validateUser(user);
        return "User " + user.getFirstName() + " added Successfully ";
    }

    @GetMapping("/possibleMerge")
    public String possibleMerge(@RequestBody User user)throws TechnicalException{
        return userService.possibleMerge(user);
    }

    @PutMapping("/autoMerge")
    public String autoMerge(@RequestBody User user)throws TechnicalException{
        return userService.autoMerge(user);
    }


}
