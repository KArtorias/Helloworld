package com.helloworld.dao;

import com.helloworld.projo.User;
import com.helloworld.projo.param.UserQuery;
import com.helloworld.projo.param.UserUpdate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //告诉springboot这是一个mybatis
public interface UserDao {
    List<User> queryUserList(UserQuery query);

    Integer countUsers(UserQuery query);

    User queryUserByName(String name);

    User queryUserById(Integer id);

    Integer addUser(User user);

    Integer updateUser(UserUpdate userUpdate);

    Integer deleteUser(Integer id);
}
