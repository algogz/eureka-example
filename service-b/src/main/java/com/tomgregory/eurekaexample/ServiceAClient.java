package com.tomgregory.eurekaexample;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("service-a")
public interface ServiceAClient  {
    @RequestMapping("/whoami")
    String whoami();
}
