package com.csw.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by HIAPAD on 2019/12/13.
 */
@Component
@FeignClient(value = "springcloud-app-info")
public interface ProductFeign {
    @RequestMapping("/info/sale")
    String sale(@RequestParam("id") String id, @RequestParam("count") Integer count);
}
