package com.zking.ssm.annotation;


import lombok.ToString;

@ToString
public class Teacher {

    @MyNotNull(value = true, message = "姓名不能为空")
    private String name;

    @MyNotNull
    private Integer age;

    public Teacher() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
