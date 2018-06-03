package com.dimple.service.impl;

import com.dimple.dao.QuestionDao;
import com.dimple.entity.Paper;
import com.dimple.entity.Question;
import com.dimple.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dimple on 2018/6/2/15:41
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionDao questionDao;

    /**
     * 获取Question的集合
     *
     * @return
     */
    @Override
    public List<Question> getQuestions() {
        List<Question> questions = questionDao.getQuestions();
        return questions;
    }

    /**
     * 根据ID获取Question持久化实例
     * 如果ID不为0，那么就去查询数据库，否则直接返回空。
     *
     * @return
     */
    @Override
    public Question getQuestionById(int id) {
        if (id != 0) {
            return questionDao.getQuestionById(id);
        }
        return null;
    }

    @Override
    public void deleteQuestion(Question question) {
        if (question != null && question.getId() != 0) {
            questionDao.deleteQuestion(question);
        }
    }

    @Override
    public void addQuestion(Question question) {
        if (question != null) {
            questionDao.addQuestion(question);
        }
    }

    @Override
    public List<Question> findQuestions(String name) {
        if (!"".equals(name)) {
            return questionDao.findQuestions(name);
        }
        return null;
    }

    @Override
    public void updateQuestion(Question question) {
        if (question != null && question.getId() != 0 && question.getPaper() != null) {
            Paper paper = new Paper();
            paper.setId(question.getPaper().getId());
            question.setPaper(paper);
            questionDao.updateQuestion(question);
        }
    }
}
