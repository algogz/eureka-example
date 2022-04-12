package com.tomgregory.eurekaexample;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("service-b")
public interface ServiceBClient {
    @RequestMapping("/whoami")
    String whoami();
}
