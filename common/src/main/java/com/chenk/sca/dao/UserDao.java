package com.chenk.sca.dao;

import com.chenk.sca.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author chenk
 * @create 2023/3/2 15:56
 */
@Mapper
public interface UserDao {
    User getUsers(String username);
}
