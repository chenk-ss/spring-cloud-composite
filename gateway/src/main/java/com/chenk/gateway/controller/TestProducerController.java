package com.chenk.gateway.controller;

/**
 * @Author chenk
 * @create 2023/3/1 23:08
 */

import com.chenk.sca.pojo.MyMessage;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 生产者
 **/
@RestController
@RequestMapping("/api/testRocketMQ")
public class TestProducerController {

    /**
     * 用于发送消息到 RocketMQ 的api
     */
    @Resource
    public RocketMQTemplate rocketMQTemplate;

    @GetMapping("/sendMsg")
    public String testSendMsg() {
        String topic = "sca-test-topic";
        MyMessage message = new MyMessage();
        message.setId(1);
        message.setName("chenk");
        message.setStatus("default");
        message.setCreateTime(new Date());
        // 发送消息
        rocketMQTemplate.convertAndSend(topic, message);

        return "send message success";
    }
}
