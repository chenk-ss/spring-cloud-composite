package com.chenk.sca.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author chenk
 * @create 2023/2/28 15:48
 */
@Data
public class User implements Serializable {
    private long id;
    private String username;
    private String password;
}
