package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.StudentMapper;
import com.zking.ssm.model.Student;
import com.zking.ssm.service.IStudentService;
import com.zking.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int deleteByPrimaryKey(Long userId) {
        return studentMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    @Override
    public Student selectByPrimaryKey(Student record) {
        return studentMapper.selectByPrimaryKey(record.getUserId());
    }

    @Override
    public int updateByPrimaryKeySelective(Student record)
    {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student record)
    {
        return studentMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Student> list(Student record, PageBean pageBean) {
        return studentMapper.list(record);
    }

    @Override
    public int deleteAll(Student student) {
        return studentMapper.deleteAll(student);
    }
}
