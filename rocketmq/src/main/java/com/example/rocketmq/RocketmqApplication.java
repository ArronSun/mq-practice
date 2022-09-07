package com.example.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.*"})
public class RocketmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketmqApplication.class, args);
    }

}
