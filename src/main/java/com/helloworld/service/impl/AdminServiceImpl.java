package com.helloworld.service.impl;

import com.helloworld.projo.User;
import com.helloworld.service.UserService;
import org.springframework.stereotype.Service;

@Service("adminServiceImpl")
public class AdminServiceImpl implements UserService {

    @Override
    public User getUser() {
        User u = new User(100, "admin:张三","男", 18);
        System.out.println("AdminServiceImpl getUser: "+u.toString());
        return u;
    }

    @Override
    public User addUser(User u) {
        u.setName("admin:"+u.getName());
        System.out.println("AdminServiceImpl addUser: "+u.toString());
        return u;
    }
}
