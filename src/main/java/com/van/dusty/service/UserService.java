package com.van.dusty.service;

import com.van.dusty.model.UserDO;
import com.van.dusty.util.ResultMsg;

import java.util.List;

public interface UserService {
    int addUser(UserDO user);
    List<UserDO> findAllUser(int pageNum, int pageSize);

    UserDO selectUser(Long id);

    ResultMsg userLogin(UserDO userDO);

}
