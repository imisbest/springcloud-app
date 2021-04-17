package com.csw.feign;

import com.csw.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "springcloud-app-info")
public interface FeignProductTest {
    @RequestMapping(value = "/test/test2")
    User test2(User user);

    @RequestMapping(value = "/test/test3")
    String test3(@RequestParam("info") String info);
}
