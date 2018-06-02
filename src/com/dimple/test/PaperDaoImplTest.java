package com.dimple.test;

import com.dimple.dao.PaperDao;
import com.dimple.dao.impl.PaperDaoImpl;
import com.dimple.entity.Paper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Dimple on 2018/6/1/19:02
 */
class PaperDaoImplTest {
    ApplicationContext context;
    @BeforeEach
    void setUp() {
        context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }
    @Test
    void getPaperAll() {
        PaperDaoImpl paperDaoImpl = (PaperDaoImpl) context.getBean("paperDaoImpl");
        List<Paper> paperAll = paperDaoImpl.getPaperAll();
    }

    @Test
    public void updatePaper(){
        PaperDao paperDaoImpl = (PaperDao) context.getBean("paperDaoImpl");
        Paper paper = new Paper();
        paper.setName("Test");
        paper.setId(1);
        paperDaoImpl.updatePaper(paper);
    }
}