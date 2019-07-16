package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.UserMapper;
import com.zking.ssm.model.User;
import com.zking.ssm.service.IUserService;
import com.zking.ssm.shiro.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String doLogin(User user) {
        String message = null;
        User u = userMapper.selectByPrimaryKey(user);
        if (null == u || !PasswordHelper.checkCredentials(user.getPassword(), u.getSalt(), u.getPassword())) {
            message = "帐号或密码错误";
        } else if (new Integer(1).equals(u.getLocked())) {
            message = "帐号已锁定，请与管理员联系";
        }
        return message;
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int updatePassword(User user) {
        String message = null;

        User u = userMapper.selectByPrimaryKey(user);

        if(null == u || !PasswordHelper.checkCredentials(user.getPassword(),u.getSalt(),u.getPassword())){
            message = "密码错误!";
        }
        String salt = PasswordHelper.createSalt();
        String credentials = PasswordHelper.createCredentials(user.getNewpassword(), salt);

        user.setUsername(user.getUsername());
        user.setSalt(salt);
        user.setNewpassword(credentials);

        return userMapper.updatePassword(user);
    }

    @Override
    public int doResetPassword(User user) {
        //md5+盐
        String salt = PasswordHelper.createSalt();
        String credentials = PasswordHelper.createCredentials(User.DEFAULT_PASSWORD, salt);


        user.setUsername(user.getUsername());
        user.setPassword(credentials);
        user.setSalt(salt);
        return userMapper.doResetPassword(user);
    }

    @Override
    public User loadByUsername(User user) {
        return userMapper.selectByPrimaryKey(user);
    }

    @Override
    public Set<String> listPermissionsByUserName(User user) {
        return userMapper.listPermissionsByUserName(user);
    }

    @Override
    public Set<String> listRolesByUserName(User user) {
        return userMapper.listRolesByUserName(user);
    }

    @Override
    public int doRegister(User user) {
        //md5+盐
        String salt = PasswordHelper.createSalt();
        String credentials = PasswordHelper.createCredentials(user.getPassword(), salt);

        user.setSalt(salt);
        user.setPassword(credentials);
        return userMapper.insertSelective(user);
    }




}
