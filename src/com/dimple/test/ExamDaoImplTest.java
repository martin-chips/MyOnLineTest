package com.dimple.test;

import com.dimple.dao.ExamDao;
import com.dimple.entity.Exam;
import com.dimple.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Dimple on 2018/6/3/12:00
 */
class ExamDaoImplTest {
    ApplicationContext context;
    Student student;
    @BeforeEach
    void setUp() {
        context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }
    @Test
    void getExamById() {
        ExamDao examDao = (ExamDao) context.getBean("examDaoImpl");
        Exam examById = examDao.getExamById(1);

    }


    @Test
    void getExamList() {
        ExamDao examDao = (ExamDao) context.getBean("examDaoImpl");
        List<Exam> examList = examDao.getExamList();
    }

    @Test
    public void testExampleFind(){
        ExamDao examDao = (ExamDao) context.getBean("examDaoImpl");
    }
}