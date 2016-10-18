package com.lp.summary.dao.test;

import java.util.UUID;

/**
 * Created by Administrator on 2016/9/2.
 */
public class AppMain {
    public static void main(String[] args) {
      /*  ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-dao.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        UserBean userBean = new UserBean();
        userBean.setPassword("123456");
        userBean.setUsername("zhangsan");
        userBean.setRealname("张三");
        userBean.setUserroleid(1);
        userBean.setCreatedate(new Date());
        if (userDao.add(userBean)>=0){
            System.out.print("添加成功");
        }*/
     System.out.print(UUID.randomUUID().toString());
    }
}
