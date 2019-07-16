package com.zking.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

@Controller
public class indexController {

    @RequestMapping("/toIndex")
    public String toIndex(HttpServletRequest request){
        RequestContext requestContext = new RequestContext(request);
        String errorMsg = requestContext.getMessage("login.error.label");
        System.out.println("errorMsg:" + errorMsg);
        System.out.println("toIndex");
        return "lacale";
    }


}
