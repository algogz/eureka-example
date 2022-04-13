package com.tomgregory.eurekaexample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaClientAController {
    private String applicationName;
    private EurekaClientBClient serviceBClient;

    public EurekaClientAController(@Value("${spring.application.name}") String applicationName, EurekaClientBClient serviceBClient) {
        this.applicationName = applicationName;
        this.serviceBClient = serviceBClient;
    }

    @GetMapping(path = "whoami")
    public String whoami() {
        return String.format("You are calling %s!", applicationName);
    }

    @GetMapping(path = "call")
    public String call() {
        return serviceBClient.whoami();
    }
}
