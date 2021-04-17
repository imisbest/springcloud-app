package com.csw.feign;

import com.csw.entity.Product_info;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "springcloud-app-info")
public interface FeignProductTest {
    @RequestMapping(value = "/info/queryProductByID")
    Product_info queryProductByID(@RequestParam("id") String id);
}
