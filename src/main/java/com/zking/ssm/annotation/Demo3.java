package com.zking.ssm.annotation;

import org.springframework.stereotype.Component;

@Component
public class Demo3 {

    private Integer age;

    @MyLog(desc = "测试测试!!!")
    public void hello(String name) {
        System.out.println("hello:" + name);
    }

}
