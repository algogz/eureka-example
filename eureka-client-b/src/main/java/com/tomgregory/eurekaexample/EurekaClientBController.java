package com.tomgregory.eurekaexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaClientBController {
    private EurekaClientAClient serviceAClient;

    public EurekaClientBController(EurekaClientAClient serviceAClient) {
        this.serviceAClient = serviceAClient;
    }

    @GetMapping(path = "whoami")
    public String whoami() {
        return "You are calling serrvice-b!";
    }

    @GetMapping(path = "call")
    public String call() {
        return serviceAClient.whoami();
    }
}
