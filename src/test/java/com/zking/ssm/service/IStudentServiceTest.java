package com.zking.ssm.service;

import com.zking.ssm.model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class IStudentServiceTest extends BaseTestCase{
    @Autowired
    private  IStudentService studentService;

    private Student student;
    @Before
    public void setUp() throws Exception {
        super.before();
        student = new Student();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deleteAll() {
        student.setUserIds(new Long[]{24l,25l});
        studentService.deleteAll(student);
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void list() throws  Exception{
       List<Student> studentList = studentService.list(student,pageBean);
       for (Student s:studentList){
           System.out.println(s);
       }
        System.out.println(pageBean);
    }

    @Test
    public void insert() throws  Exception{
        student = new Student();
        student.setUserId(null);
        student.setUsername("abb1");
        student.setPassword("123");
        student.setSalt("7e2527b148801f6c79424ace88d08124");
        student.setLocked(555);
        student.setCreateDatetime(new Date());

        studentService.insert(student);
        System.out.println(student);
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() throws  Exception{
        student.setUserId(5L);
        Student s = studentService.selectByPrimaryKey(student);
        System.out.println(s);
    }

    @Test
    public  void updateByPrimaryKeySelective()throws  Exception{

    }

    @Test
    public void updateByPrimaryKey()throws  Exception{
        student.setUserId(6l);
        student.setUsername("ss");
        student.setPassword("456");
        student.setSalt("aa");
        student.setLocked(666);
        student.setCreateDatetime(new Date());

        studentService.updateByPrimaryKey(student);
    }
}