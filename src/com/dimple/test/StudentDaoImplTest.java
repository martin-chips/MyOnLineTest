package com.dimple.test;

import com.dimple.dao.StudentDao;
import com.dimple.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dimple on 2018/5/17/16:56
 */
class StudentDaoImplTest {
    ApplicationContext context;
    Student student;
    @org.junit.jupiter.api.BeforeEach
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
    public void testUpdatePassword() {
        StudentDao studentDao = (StudentDao) context.getBean("studentDaoImpl");
        studentDao.updatePassword(student, "newtest");
    }


}