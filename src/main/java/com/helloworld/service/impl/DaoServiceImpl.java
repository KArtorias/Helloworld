package com.helloworld.service.impl;

import com.helloworld.dao.UserDao;
import com.helloworld.projo.User;
import com.helloworld.projo.UserResult;
import com.helloworld.projo.param.UserQuery;
import com.helloworld.service.DaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DaoServiceImpl implements DaoService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserResult queryUserList(UserQuery query) {
        if (query.getLimit()==null) {
            query.setLimit(10);
        }
        if (query.getOffset() == null || query.getOffset().intValue() < 0) {
            query.setOffset(0);
        }

        System.out.println("Dao UserQuery: " + query.toString());

        List<User> users = userDao.queryUserList(query);

        Integer total = userDao.countUsers(query);

        int count = 0;
        if (total != null){
            count = total.intValue();
        }

        UserResult result = new UserResult();
        result.setUsers(users);
        result.setLimit(query.getLimit());
        result.setOffset(query.getOffset());
        result.setCount(count);

        return result;
    }

    @Override
    public User queryUserByName(String name) {
        return userDao.queryUserByName(name);
    }

    @Override
    public User addUser(User user) {
        int result = userDao.addUser(user);
        if (result != 1) {
            System.out.println("addUser failex");
        }
        return user;
    }
}
