package com.mvc.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class RefreshController {

    @Value("${spring.cloud.config.value}")
    String value;

    @GetMapping("/config")
    public String getData(){
        return value;
    }
}
