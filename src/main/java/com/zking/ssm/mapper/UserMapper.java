package com.zking.ssm.mapper;

import com.zking.ssm.model.User;

import java.util.Set;

public interface UserMapper {

    User doLogin(User user);//用户登陆

    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(User user);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int updatePassword(User user);//所有人都可以修改自己的密码

    int doResetPassword(User user);//管理员可以重置所有人的密码，密码默认值为888888

    Set<String> listPermissionsByUserName(User user);//查询指定用户拥有的权限
    Set<String> listRolesByUserName(User user);//查询指定用户拥有的角色
}