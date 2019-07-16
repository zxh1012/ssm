package com.zking.ssm.service;

import com.zking.ssm.model.Role;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class IRoleServiceTest extends BaseTestCase {
    @Autowired
    private IRoleService roleService;

    private Role role;

    @Before
    public void setUp() throws Exception {
        role = new Role();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void add() throws Exception{
        role.setRoleId(null);
        role.setRoleName("mmm");
        role.setAvailable(1);
        role.setDescription("游客");

        roleService.add(role);
        System.out.println(role);
    }

    @Test
    public void del() throws Exception{
        role.setRoleId(3L);
        roleService.del(role);
    }

    @Test
    public void doGrantRoleToUser() throws Exception{
        role.setUserId(3L);
        role.setRoleId(4l);


        roleService.doGrantRoleToUser(role);
        System.out.println(role);
    }

    @Test
    public void doRevokeRoleFromUser() throws Exception{
        role.setUserId(3l);
        roleService.doRevokeRoleFromUser(role);
    }

    @Test
    public void doGrantPermissionToRole() throws Exception{
        role.setRoleId(4L);
        role.setPermissionId(2L);

        roleService.doGrantPermissionToRole(role);
    }

    @Test
    public void doRevokePermissionFromRole() throws Exception{
        role.setRoleId(4L);
        roleService.doRevokePermissionFromRole(role);
    }
}