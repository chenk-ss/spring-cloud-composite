package com.chenk.sca.oauth.service.impl;

import com.chenk.sca.dao.UserDao;
import com.chenk.sca.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @Author chenk
 * @create 2023/3/2 19:50
 */
@Slf4j
@Component
public class AuthUserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("username:" + username);
        // 查询数据库操作
        User users = userDao.getUsers(username);
        if (StringUtils.isBlank(users.getPassword())) {
            throw new UsernameNotFoundException("the user is not found");
        }
        String password = passwordEncoder.encode(users.getPassword());
        return new org.springframework.security.core.userdetails.User(username, password, new ArrayList<>());
    }
}
