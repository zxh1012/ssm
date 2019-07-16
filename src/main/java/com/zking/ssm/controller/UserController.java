package com.zking.ssm.controller;

import com.zking.ssm.model.User;
import com.zking.ssm.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ModelAttribute
    public void init(Model model) {
        System.out.println("init");
        User user = new User();
        model.addAttribute("user", user);
    }

    @RequestMapping("/index.shtml")
    public String toLogin(Model model) {
        System.out.println("toLogin");
        return "login";
    }

    @ResponseBody
    @RequestMapping("/login")
    public Map<String,Object> login(Model model, User user) {
        Map<String,Object> map = new HashMap<String,Object>();
        System.out.println(user);
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        String message = null;
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {// 捕获未知用户名异常
            message = "帐号错误";
        } catch (LockedAccountException e) {// 捕获错误登录过多的异常
            message = "帐号已锁定，请与管理员联系";
        } catch (IncorrectCredentialsException e) {// 捕获密码错误异常
            message = "密码错误";
        } catch (ExcessiveAttemptsException e) {// 捕获错误登录过多的异常
            message = "多次登录尝试失败，请60秒后再试";
        }

        if (null == message) {
            Session session = subject.getSession();//此session为org.apache.shiro.session.Session
            session.setAttribute("user", user);//登陆成功后要保存shiro的会话中，已备之后使用
//            return "redirect:/cu/list";
            map.put("message","登录成功");
            map.put("code",0);
        } else {
            model.addAttribute("message", message);
//            return "login";
            map.put("message",message);
            map.put("code",-1);
        }
        return map;
    }


    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "login";
    }

    @RequestMapping("/updatepassword")
    public String updatepassword(String password,String newpassword,HttpSession session) {
        User user = (User)session.getAttribute("user");
        user.setPassword(password);
        user.setNewpassword(newpassword);
        userService.updatePassword(user);
        return "redirect:/";
    }

    @RequiresPermissions("system:user:updatePassword")
    @RequestMapping("/toupdatepassword")
    public String toupdatepassword() {
        return "updatepassword";
    }




}
