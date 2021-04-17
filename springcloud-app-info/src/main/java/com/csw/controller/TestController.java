package com.csw.controller;

import com.csw.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("test1")
    public String test(String name) {
        return "name 8771:" + name;
    }

    @RequestMapping("test2")
    public User test2(@RequestBody User user) {
        System.out.println("进入user");
        return user;
    }

    @RequestMapping("test3")
    public String test3(String info) {
        System.out.println("info]" + info);
        return info;
    }
}
