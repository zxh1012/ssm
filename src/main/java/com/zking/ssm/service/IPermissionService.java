package com.zking.ssm.service;


import com.zking.ssm.model.Permission;

public interface IPermissionService {
    int add(Permission permission);
    int del(Permission permission);
}
