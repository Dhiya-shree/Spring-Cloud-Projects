package com.mvc.cloud_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableFeignClients(basePackages ="com.mvc.cloud_service.comm")
@SpringBootApplication
public class CloudServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudServiceApplication.class, args);
    }

}
