package com.csw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.csw.dao")
public class SpringcloudAppMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudAppMasterApplication.class, args);
    }

}
