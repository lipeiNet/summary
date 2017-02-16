package com.lp.summary.sharding.service.impl;

import com.lp.summary.sharding.entity.Student;
import com.lp.summary.sharding.mapper.StudentMapper;
import com.lp.summary.sharding.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/2/7.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    public StudentMapper studentMapper;

    public boolean insert(Student student) {
        return studentMapper.insert(student) > 0 ? true : false;
    }
}
