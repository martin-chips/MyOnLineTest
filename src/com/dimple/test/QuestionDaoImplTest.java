package com.dimple.test;

import com.dimple.dao.QuestionDao;
import com.dimple.entity.Paper;
import com.dimple.entity.Question;
import com.dimple.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Dimple on 2018/6/2/17:11
 */
class QuestionDaoImplTest {
    ApplicationContext context;
    Student student;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @Test
    void getQuestions() {
        QuestionDao questionDao = (QuestionDao) context.getBean("questionDaoImpl");
        List<Question> questions = questionDao.getQuestions();
        System.out.println(questions);
    }

    @Test
    void testquery() {
        QuestionDao questionDao = (QuestionDao) context.getBean("questionDaoImpl");
        List<Question> question = questionDao.findQuestions("一个");
        System.out.println(question);
    }

    @Test
    public void updateQuestion() {
        QuestionDao questionDao = (QuestionDao) context.getBean("questionDaoImpl");
        Question question = new Question();
        question.setId(2);
        Paper paper = new Paper();
        paper.setId(4);
        question.setPaper(paper);
        question.setQuestion("Test");
        questionDao.updateQuestion(question);


    }
}