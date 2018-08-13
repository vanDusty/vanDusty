package com.van.dusty.service;

import com.van.dusty.model.UserDO;
import com.van.dusty.util.ResultMsg;

import java.util.List;

public interface UserService {

    public ResultMsg userLogin(UserDO userDO);

    public ResultMsg registerAccount(UserDO userDO);
}
