package com.lp.summary.sharding;

import com.lp.summary.sharding.entity.Student;
import com.lp.summary.sharding.entity.User;
import com.lp.summary.sharding.service.StudentService;
import com.lp.summary.sharding.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/2/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-sharding.xml"})
public class ShardingJdbcMybatisTest {
    @Resource
    public UserService userService;

    @Resource
    public StudentService studentService;

    @Test
    public void testUserInsert() {
        User u = new User();
        u.setUserId(11);
        u.setAge(25);
        u.setName("github");
        Assert.assertEquals(userService.insert(u), true);
    }

    @Test
    public void testStudentInsert() {
        Student student = new Student();
        student.setStudentId(21);
        student.setAge(21);
        student.setName("hehe");
        Assert.assertEquals(studentService.insert(student), true);
    }

    @Test
    public void testFindAll() {
        List<User> users = userService.findAll();
        if (null != users && !users.isEmpty()) {
            for (User u : users) {
                System.out.println(u);
            }
        }
    }

    @Test
    public void testSQLIN() {
        List<User> users = userService.findByUserIds(Arrays.asList(2, 10, 1));
        if (null != users && !users.isEmpty()) {
            for (User u : users) {
                System.out.println(u);
            }
        }
    }

    @Test
    public void testTransactionTestSucess() {
        userService.transactionTestSucess();
    }

    @Test(expected = IllegalAccessException.class)
    public void testTransactionTestFailure() throws IllegalAccessException {
        userService.transactionTestFailure();
    }
}
