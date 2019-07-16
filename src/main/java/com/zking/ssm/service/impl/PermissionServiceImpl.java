package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.PermissionMapper;
import com.zking.ssm.model.Permission;
import com.zking.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional

@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int add(Permission permission) {
        return permissionMapper.insert(permission);
    }

    @Override
    public int del(Permission permission) {
        return permissionMapper.deleteByPrimaryKey(permission.getPermissionId());
    }
}
