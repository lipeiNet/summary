package com.lp.summary.sharding.mapper;

import com.lp.summary.sharding.entity.Student;

import java.util.List;

/**
 * Created by Administrator on 2017/2/7.
 */
public interface StudentMapper {
    Integer insert(Student s);
    List<Student> findAll();
    List<Student> findByStudentIds(List<Integer> studentIds);
}
