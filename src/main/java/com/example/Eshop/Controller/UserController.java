package com.example.Eshop.Controller;

import com.example.Eshop.Dto.PersonalData;
import com.example.Eshop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/newUser")
    public void savePersonalData(@RequestBody PersonalData personalData) {
        userService.savePersonalData(personalData);
    }
}