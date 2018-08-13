package com.van.dusty.service.impl;

import com.github.pagehelper.PageHelper;
import com.van.dusty.model.UserDO;
import com.van.dusty.mapper.UserDOMapper;
import com.van.dusty.service.UserService;
import com.van.dusty.util.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDOMapper userDOMapper;//这里会报错，但是并不会影响


    @Override
    public ResultMsg userLogin(UserDO userDO) {
        ResultMsg result = new ResultMsg();
        UserDO user = userDOMapper.selectUserByUserName(userDO.getUserName());
        if (null == user) {
            result.setCode("404");
            result.setMsg("该用户不存在！");
            return result;
        }
        if (!user.getPassword().equals(userDO.getPassword())) {
            result.setCode("250");
            result.setMsg("用户密码不对！");
            return result;
        }
        result.setCode("200");
        return result;
    }

    @Override
    public ResultMsg registerAccount(UserDO userDO) {
        ResultMsg result = new ResultMsg();
        UserDO user = userDOMapper.selectUserByUserName(userDO.getUserName());
        if (null != user) {
            result.setCode("400");
            result.setMsg("该用户名已存在！");
            return result;
        }
        userDO.setNickName(userDO.getUserName());
        int num = userDOMapper.insertSelective(userDO);
        if (num == 0) {
            result.setCode("401");
            result.setMsg("注册失败！");
            return result;
        }
        result.setCode("200");
        return result;
    }
}
