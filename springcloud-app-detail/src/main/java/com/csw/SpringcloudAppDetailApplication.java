package com.csw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.csw.dao")
@EnableEurekaClient
@EnableFeignClients
public class SpringcloudAppDetailApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudAppDetailApplication.class, args);
    }

}
