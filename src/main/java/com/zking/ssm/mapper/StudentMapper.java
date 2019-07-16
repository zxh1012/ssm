package com.zking.ssm.mapper;

import com.zking.ssm.model.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> list(Student record);

    int deleteByPrimaryKey(Long userId);

    int deleteAll(Student student);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}