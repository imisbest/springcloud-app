package com.csw.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "springcloud-app-master")
public interface FeignProductTest {
    @RequestMapping(value = "/master/master")
    String chuansong(@RequestParam("id") String id);
}
