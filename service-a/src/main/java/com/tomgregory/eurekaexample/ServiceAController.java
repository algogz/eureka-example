package com.tomgregory.eurekaexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceAController {
    private ServiceBClient serviceBClient;

    public ServiceAController(ServiceBClient serviceBClient) {
        this.serviceBClient = serviceBClient;
    }

    @GetMapping(path = "whoami")
    public String whoami() {
        return "You are calling serrvice-a!";
    }

    @GetMapping(path = "call")
    public String call() {
        return serviceBClient.whoami();
    }
}
