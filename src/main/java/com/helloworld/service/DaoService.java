package com.helloworld.service;

import com.helloworld.projo.User;
import com.helloworld.projo.UserResult;
import com.helloworld.projo.param.UserQuery;

import java.util.List;

public interface DaoService {
    UserResult queryUserList(UserQuery query);

    User queryUserByName(String name);

    User addUser(User user);
}
