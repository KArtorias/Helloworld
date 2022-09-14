package com.helloworld.controller;

import com.helloworld.projo.User;
import com.helloworld.service.PeopleService;
import com.helloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @Resource(name="userServiceImpl")
    private UserService userService;

    @Resource(name="adminServiceImpl")
    private UserService adminService;

    @Autowired
    private PeopleService peopleService;

    @GetMapping("/user")
    public User getUserV1(){
        return userService.getUser();
    }

    @GetMapping("/admin")
    public User getUserV2(){
        return adminService.getUser();
    }

    @PostMapping("/user")
    public User addUserV1(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/admin")
    public User addUserV2(@RequestBody User user){
        return adminService.addUser(user);
    }

    @GetMapping("/people")
    public User getPeople(){
        return peopleService.getUser();
    }

    @Value("${local.value}")
    public String global_value;

    @GetMapping("/value")
    public String getValue(){
        return global_value;
    }
}
