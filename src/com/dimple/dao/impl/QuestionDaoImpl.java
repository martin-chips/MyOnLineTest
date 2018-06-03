package com.dimple.dao.impl;

import com.dimple.dao.QuestionDao;
import com.dimple.entity.Question;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dimple on 2018/6/2/15:45
 */
@Repository
public class QuestionDaoImpl implements QuestionDao {

    @Autowired
    HibernateTemplate hibernateTemplate;

    /**
     * 获取全部的Question记录
     * @return 集合
     */
    @Override
    public List<Question> getQuestions() {
        List<Question> byExample = hibernateTemplate.findByExample(new Question());
        return byExample;
    }

    /**
     * 根据ID获取Question
     * @param id
     * @return
     */
    @Override
    public Question getQuestionById(int id) {
        return hibernateTemplate.get(Question.class, id);
    }

    @Override
    public void deleteQuestion(Question question) {
        hibernateTemplate.delete(question);
    }

    /**
     * 新增Question实例
     * @param question
     */
    @Override
    public void addQuestion(Question question) {
        hibernateTemplate.save(question);
    }

    /**
     * 模糊查询
     * @param name
     * @return
     */
    @Override
    public List<Question> findQuestions(String name) {
        Session currentSession = hibernateTemplate.getSessionFactory().openSession();
        String hql = "from Question where question like ?1";
        Query query = currentSession.createQuery(hql).setParameter(1, "%" + name + "%");
        List<Question> list = query.list();
        return list;
    }

    /**
     * 更新Question持久化实例
     * @param question
     */
    @Override
    public void updateQuestion(Question question) {
//        Question questionDB = hibernateTemplate.get(Question.class, question.getId());
        hibernateTemplate.saveOrUpdate(question);
    }
}
