package com.chenk.gateway.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSON;
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

    /**
     * 测试流控规则
     */
    @GetMapping("/testFlow")
    @SentinelResource(value = "user-testFlow",
            blockHandlerClass = UserBlockHandler.class, //对应异常类
            blockHandler = "handleException",  //只负责sentinel控制台配置违规
            fallback = "handleError",   //只负责业务异常
            fallbackClass = UserBlockHandler.class)
    public String testFlow() {
        User user = userService.userInfo();
        return JSON.toJSONString(user);
    }

    /**
     * 测试降级规则
     */
    @GetMapping("/testDegrade")
    @SentinelResource(value = "user-testDegrade",
            blockHandlerClass = UserBlockHandler.class, //对应异常类
            blockHandler = "handleException",  //只负责sentinel控制台配置违规
            fallback = "handleError",   //只负责业务异常
            fallbackClass = UserBlockHandler.class)
    public String testDegrade() {
        User user = userService.userInfo();
        return JSON.toJSONString(user);
    }

}
