package com.zking.ssm.service;

import com.zking.ssm.model.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class TestCache extends BaseTestCase {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void test1(){
        Student student = new Student();
        student.setUserId(2223l);
        student.setUsername("小红是猪");
        redisTemplate.opsForValue().set(student.getUserId().toString(),student);
    }

}
