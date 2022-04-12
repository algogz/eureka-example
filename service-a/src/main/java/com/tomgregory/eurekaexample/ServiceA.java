package com.tomgregory.eurekaexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServiceA {
    public static void main(String[] args) {
        SpringApplication.run(ServiceA.class);
    }
}
