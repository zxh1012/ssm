package com.zking.ssm.service;

import com.zking.ssm.model.Student;
import com.zking.ssm.util.PageBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IStudentService {
    List<Student> list(Student record, PageBean pageBean);

    int deleteByPrimaryKey(Long userId);

    int insert(Student record);

    int insertSelective(Student record);

    @Transactional(readOnly = true)
//    @Cacheable(value = "student",unless = "#result == null")
    Student selectByPrimaryKey(Student record);

    int updateByPrimaryKeySelective(Student record);

//    @CacheEvict(value = "student")
    int updateByPrimaryKey(Student record);

    int deleteAll(Student sudent);
}
