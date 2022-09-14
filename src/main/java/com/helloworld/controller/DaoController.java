package com.helloworld.controller;

import com.helloworld.projo.User;
import com.helloworld.projo.param.UserQuery;
import com.helloworld.service.DaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/dao")
public class DaoController {
    @Resource(name="daoServiceImpl")
    private DaoService daoService;

    @GetMapping("/user")
    public List<User> getUser(@RequestParam(value = "limit", required = false) int limit,
                              @RequestParam(value = "offset", required = false) int offset,
                              @RequestParam(value = "name",required = false, defaultValue = "def_name") String name){
        UserQuery userQuery = new UserQuery();
        userQuery.setOffset(offset);
        userQuery.setLimit(limit);
        userQuery.setName(name);

        System.out.println("user query: "+ userQuery.toString());
        return daoService.queryUserList(userQuery);
    }
}
