package com.chenk.sca.service.impl;

import com.chenk.sca.dao.UserDao;
import com.chenk.sca.pojo.User;
import com.chenk.sca.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author chenk
 * @create 2023/2/28 15:49
 */
@Service
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User userInfo(String username) {
        return userDao.getUsers(username);
    }
}
