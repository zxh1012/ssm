package com.zking.ssm.service;


import com.zking.ssm.model.Role;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IRoleService {
    int add(Role role);
    int del(Role role);

    //权限关键接口
    int doGrantRoleToUser(Role role);//给用户分配角色
    int doRevokeRoleFromUser(Role role);//从用户收回角色
    int doGrantPermissionToRole(Role role);//给角色分配权限
    int doRevokePermissionFromRole(Role role);//从角色收回权限
}
