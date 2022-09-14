package com.helloworld.dao;

import com.helloworld.projo.User;
import com.helloworld.projo.param.UserQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper //告诉springboot这是一个mybatis
public interface UserDao {
    List<User> queryUserList(UserQuery query);

    User queryUserByName(String name);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
