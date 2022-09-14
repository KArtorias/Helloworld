package com.helloworld.controller;

import com.helloworld.projo.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/user")
    public User getUser(){
        User u = new User(100, "张三","男", 18);
        return u;
    }

    @GetMapping("/user_by_id")
    public User getUserByIdAndName(@RequestParam(value = "id", required = false, defaultValue = "def_id") int id,
                                   @RequestParam(value = "name",required = false, defaultValue = "def_name") String name){
        User u = new User(id, name,"男", 18);

        System.out.println("user: "+u.toString());

        return u;
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        System.out.println("user: "+user.toString());
        return user;
    }

    @PutMapping("/user")
    public User putUser(@RequestBody User user) {
        System.out.println("user: "+user.toString());
        return user;
    }

    @DeleteMapping("/user")
    public User deleteUser(@RequestBody User user) {
        System.out.println("user: "+user.toString());
        return user;
    }
}
