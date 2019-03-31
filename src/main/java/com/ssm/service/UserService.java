package com.ssm.service;


import com.ssm.model.User;

public interface UserService {

    User getUser(String username, String password);
}
