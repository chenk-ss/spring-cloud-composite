package com.chenk.sca;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author chenk
 * @create 2023/2/28 15:05
 */
@SpringBootApplication
@EnableDiscoveryClient
@EntityScan("com.chenk.sca.pojo")
@MapperScan("com.chenk.sca.dao")
public class EngineApplication {
    public static void main(String[] args) {
        SpringApplication.run(EngineApplication.class, args);
    }
}
