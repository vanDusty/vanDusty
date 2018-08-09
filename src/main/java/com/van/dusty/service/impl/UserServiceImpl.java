package com.van.dusty.service.impl;

import com.github.pagehelper.PageHelper;
import com.van.dusty.model.UserDO;
import com.van.dusty.mapper.UserDOMapper;
import com.van.dusty.service.UserService;
import com.van.dusty.util.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDOMapper userDOMapper;//这里会报错，但是并不会影响

    @Override
    public int addUser(UserDO user) {

        return userDOMapper.insertSelective(user);
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public List<UserDO> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return userDOMapper.selectAllUser();
    }

    @Override
    public UserDO selectUser(Long id) {
        return userDOMapper.selectByPrimaryKey(id);
    }

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
}
