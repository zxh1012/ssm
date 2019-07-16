package com.zking.ssm.service;

import com.zking.ssm.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.Set;

public class IUserServiceTest extends BaseTestCase {

    @Autowired
    private IUserService userService;

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void doRegister() {
        user.setUsername("ll");
        user.setPassword("88888");
        user.setLocked(0);
        userService.doRegister(user);
    }

    @Test
    public void doLogin() {
        user.setUsername("ll");
        user.setPassword("88888");
        userService.doLogin(user);
    }

    @Test
    public void updatePassword() {
        user.setUsername("ll");
        user.setPassword("888888");
        user.setNewpassword("222");
        userService.updatePassword(user);

    }

    @Test
    public void doResetPassword() {
        user.setUserId(20l);
        userService.doResetPassword(user);
    }

    @Test
    public void loadByUsername() {
        user.setUsername("zs");
        User user = userService.loadByUsername(this.user);
        System.out.println(user);
    }

    @Test
    public void listPermissionsByUserName() {
        user.setUserId(1l);
        Set<String> list = userService.listPermissionsByUserName(user);
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String str = itr.next();
            System.out.println(str);
        }
    }

    @Test
    public void listRolesByUserName() {
        user.setUserId(1l);
        Set<String> list = userService.listRolesByUserName(user);
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String str = itr.next();
            System.out.println(str);
        }
    }
}