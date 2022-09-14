package com.helloworld.controller;

import com.helloworld.projo.User;
import com.helloworld.projo.UserResult;
import com.helloworld.projo.param.UserQuery;
import com.helloworld.service.DaoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/dao")
public class DaoController {
    @Resource(name="daoServiceImpl")
    private DaoService daoService;

    @GetMapping("/user")
    public UserResult getUser(@RequestParam(value = "limit", required = false) Integer limit,
                              @RequestParam(value = "offset", required = false) Integer offset,
                              @RequestParam(value = "name",required = false, defaultValue = "") String name){
        UserQuery userQuery = new UserQuery();
        userQuery.setOffset(offset);
        userQuery.setLimit(limit);
        userQuery.setName(name);

        System.out.println("user query: "+ userQuery.toString());
        return daoService.queryUserList(userQuery);
    }

    @GetMapping("/user_by_name")
    public User getUser(@RequestParam(value = "name",required = false, defaultValue = "def_name") String name){
        return daoService.queryUserByName(name);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return daoService.addUser(user);
    }
}
