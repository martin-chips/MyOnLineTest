package com.dimple.test;

import com.dimple.dao.ManagerDao;
import com.dimple.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dimple on 2018/5/27/15:14
 */
class ManagerDaoImplTest {
    ApplicationContext context;
    Student student;
    @BeforeEach
    void setUp() {

        context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        student = new Student();
        student.setId(2);
        student.setPassword("test");
        student.setName("test");
        student.setProfession("test");
        student.setSex("nan");
    }

    @Test
    void updatePassword() {
        ManagerDao managerDao = (ManagerDao) context.getBean("managerDaoImpl");
        managerDao.updatePassword(1,"hello");
    }
}