package com.tomgregory.eurekaexample;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("eureka-client-b")
public interface EurekaClientBClient {
    @RequestMapping("/whoami")
    String whoami();
}
