package com.dimple.dao.impl;

import com.dimple.dao.ExamDao;
import com.dimple.entity.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dimple on 2018/6/3/11:48
 */
@Repository
public class ExamDaoImpl implements ExamDao {
    @Autowired
    HibernateTemplate hibernateTemplate;

    @Override
    public Exam getExamById(int id) {
        Exam exam = hibernateTemplate.get(Exam.class, id);
        return exam;
    }

    @Override
    public List<Exam> getExamList() {
        List<Exam> byExample = hibernateTemplate.findByExample(new Exam());
        return byExample;
    }
}
