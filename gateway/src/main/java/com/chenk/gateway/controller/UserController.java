package com.chenk.gateway.controller;

import com.chenk.sca.pojo.User;
import com.chenk.sca.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chenk
 * @create 2023/2/28 15:50
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Reference
    private UserService userService;

    @GetMapping("/userInfo")
    public User userInfo() {
        return userService.userInfo();
    }
}
