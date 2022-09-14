package com.helloworld.service.impl;

import com.helloworld.projo.User;
import com.helloworld.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUser() {
        User u = new User(100, "张三","男", 18);
        System.out.println("UserServiceImpl getUser: "+u.toString());
        return u;
    }

    @Override
    public User addUser(User u) {
        System.out.println("UserServiceImpl addUser: "+u.toString());
        return u;
    }
}
