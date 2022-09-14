package com.helloworld.service;

import com.helloworld.projo.User;
import com.helloworld.projo.param.UserQuery;

import java.util.List;

public interface DaoService {
    List<User> queryUserList(UserQuery query);
}
