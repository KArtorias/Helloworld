package com.helloworld.service.impl;

import com.helloworld.model.User;
import com.helloworld.service.PeopleService;
import org.springframework.stereotype.Service;

@Service("peopleServiceImpl")
public class PeopleServiceImpl implements PeopleService {

    @Override
    public User getUser() {
        User u = new User(100, "people:张三","男", 18);
        System.out.println("PeopleServiceImpl getUser: "+u.toString());
        return u;
    }
}
