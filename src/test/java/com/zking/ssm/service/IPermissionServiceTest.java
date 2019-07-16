package com.zking.ssm.service;

import com.zking.ssm.model.Permission;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class IPermissionServiceTest extends BaseTestCase {
    @Autowired
    private IPermissionService permissionService;

    private Permission permission;
    @Before
    public void setUp() throws Exception {
        permission = new Permission();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() throws Exception{
        permission = new Permission();
        permission.setPermissionId(null);
        permission.setPermissionName("啦啦啦");
        permission.setLevel(2);
        permission.setParentPermissionId(6l);
        permission.setAvailable(1);
        permission.setPermission("system:user:doResetPassword");

        permissionService.add(permission);
        System.out.println(permission);
    }

    @Test
    public void del() throws Exception{
        permission.setPermissionId(9l);
        permissionService.del(permission);
    }
}