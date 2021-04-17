package com.csw.feign;

import com.csw.entity.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by HIAPAD on 2019/12/13.
 */
@FeignClient(value = "springcloud-app-detail")
public interface OrderFeign {
    @RequestMapping("/detail/createOrder")
    Map createOrder(OrderVO orderVO);
}
