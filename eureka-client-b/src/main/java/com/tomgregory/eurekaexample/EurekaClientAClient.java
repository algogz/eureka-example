package com.tomgregory.eurekaexample;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("eureka-client-a")
public interface EurekaClientAClient {
    @RequestMapping("/whoami")
    String whoami();
}
