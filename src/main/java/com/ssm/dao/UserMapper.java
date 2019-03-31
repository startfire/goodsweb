package com.ssm.dao;

import com.ssm.model.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {

    User getUser(@Param("username") String username, @Param("password") String password);
}
