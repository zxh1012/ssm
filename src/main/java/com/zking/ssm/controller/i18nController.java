package com.zking.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
public class i18nController {

    @RequestMapping("/zh")
    public String zh(HttpSession session){
        session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,Locale.CHINA);
        return "redirect:/toIndex";
    }

    @RequestMapping("/en")
    public String en(HttpSession session){
        session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,Locale.US);
        return "redirect:/toIndex";
    }

    public static void main(String[] args) {
        Locale china = Locale.CHINA;
        System.out.println(china);

        Locale japan = Locale.JAPAN;
        System.out.println(japan);

        Locale us = Locale.US;
        System.out.println(us);
    }
}
