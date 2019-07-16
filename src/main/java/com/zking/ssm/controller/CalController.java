package com.zking.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cal")
public class CalController {

    @ModelAttribute
    public void init(Model model, ModelAndView modelAndView){
        System.out.println("init");
        model.addAttribute("name","dd");
    }

    @RequestMapping("/add")
    public String add(Model model){
        System.out.println("add");
        Object name = model.asMap().get("name");
        System.out.println(name);

        String prefix = "/WEB-INF/jsp/";
        String suffix = ".jsp";
        String s = "msg";
        String path = prefix + s  + suffix;
        System.out.println(path);
        return  "msg";
    }

    @RequestMapping("/toTest")
    public String toTest(){
        return "test";
    }

    @RequestMapping("/div")
    public String div(){
        System.out.println();
        String prefix = "/WEB-INF/jsp/";
        String suffix = ".jsp";
        String s = "test";
        String path = prefix + s  + suffix;
        System.out.println(path);
        return  "redirect:toTest";
    }
}
