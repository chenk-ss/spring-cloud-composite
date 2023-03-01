package com.chenk.sca.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author chenk
 * @create 2023/3/1 23:08
 */
@Data
public class MyMessage implements Serializable {
    private Integer id;
    private String name;
    private String status;
    private Date createTime;
}
