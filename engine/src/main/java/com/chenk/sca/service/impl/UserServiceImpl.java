package com.chenk.sca.service.impl;

import com.chenk.sca.pojo.User;
import com.chenk.sca.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @Author chenk
 * @create 2023/2/28 15:49
 */
@Service
@Component
public class UserServiceImpl implements UserService {
    @Override
    public User userInfo() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        return user;
    }
}
