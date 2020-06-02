package com.test.oauth.controller;

import com.test.oauth.entities.UserSecurityEntity;
import com.test.oauth.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private IUserService iUserService;

    // No secure.
    @PostMapping("/api/users/create")
    public Map createUser(@RequestBody UserSecurityEntity userSecurityEntity) {
        UserSecurityEntity newUserCreated = this.iUserService.save(userSecurityEntity);
        Map<String, Object> result = new HashMap<>();
        result.put("user", newUserCreated);
        return result;
    }

    // Secure.
    @GetMapping("/api/users/get/all")
    public List<UserSecurityEntity> getAllUsers() {
        return this.iUserService.getAll();
    }

}
