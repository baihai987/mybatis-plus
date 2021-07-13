package com.mybts.pls.controller;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybts.pls.mypls.entity.User;
import com.mybts.pls.mypls.mapper.UserMapper;
import com.mybts.pls.mypls.service.IUserService;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.RequestingUserName;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
public class UserTestController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IUserService userService;

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Integer id) {
        User user = new User();
        user.setAge(33);
        user.setEMail("dididi.com");
        user.setName("bhy");
        int insert = userMapper.insert(user);
        return insert + "";
    }

    @GetMapping("update")
    public String updateUser(){
        List<User> list = userService.list(null);
        for (User user :list){
            user.setUpTime(LocalDateTime.now());
            user.setCTime(LocalDateTime.now());
            user.setIsDelete(true);
            userService.updateById(user);
        }
        return "ok";
    }

    @GetMapping("/getAll")
    public Page<User> getAll(){
        Page<User> userPage = new Page<>();
        userPage.setCurrent(1);
        userPage.setSize(3);
        QueryWrapper<User> wrapper= new QueryWrapper<>();
        wrapper.eq("is_delete",1);
        Page<User> page = userService.page(userPage, wrapper);
        return page;
    }
}
