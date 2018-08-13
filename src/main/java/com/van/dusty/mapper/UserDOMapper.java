package com.van.dusty.mapper;

import com.van.dusty.model.UserDO;

import java.util.List;

public interface UserDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

    //我自己加的
    List<UserDO> selectAllUser();

    UserDO selectUserByUserName(String nickName);

}