package com.tomgregory.eurekaexample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaClientBController {
    private String applicationName;
    private EurekaClientAClient serviceAClient;

    public EurekaClientBController(@Value("${spring.application.name}") String applicationName, EurekaClientAClient serviceAClient) {
        this.applicationName = applicationName;
        this.serviceAClient = serviceAClient;
    }

    @GetMapping(path = "whoami")
    public String whoami() {
        return String.format("You are calling %s!", applicationName);
    }

    @GetMapping(path = "call")
    public String call() {
        return serviceAClient.whoami();
    }
}
