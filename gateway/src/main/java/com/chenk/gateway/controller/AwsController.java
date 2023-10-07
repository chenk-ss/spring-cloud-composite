package com.chenk.gateway.controller;

import com.chenk.sca.service.AwsE3Service;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aws")
public class AwsController {

    @Reference
    private AwsE3Service awsE3Service;

    @PostMapping("/e3/upload")
    public void upload() {
        try {
            awsE3Service.upload();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

