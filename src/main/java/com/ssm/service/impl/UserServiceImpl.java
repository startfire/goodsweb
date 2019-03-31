package com.ssm.service.impl;


import com.ssm.dao.UserMapper;
import com.ssm.model.User;
import com.ssm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    //验证用户名和密码
    @Override
    public User getUser(String username, String password) {
        return userMapper.getUser(username, password);
    }
}
