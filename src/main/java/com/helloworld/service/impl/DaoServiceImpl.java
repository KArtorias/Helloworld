package com.helloworld.service.impl;

import com.helloworld.dao.UserDao;
import com.helloworld.projo.User;
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
    public List<User> queryUserList(UserQuery query) {
        if (query.getLimit()==0) {
            query.setLimit(10);
        }
        if (query.getOffset() < 0) {
            query.setOffset(0);
        }

        return userDao.queryUserList(query);
    }
}
