package com.dimple.dao;

import com.dimple.entity.Question;

import java.util.List;

/**
 * Created by Dimple on 2018/6/2/15:41
 */
public interface QuestionDao {

    public List<Question> getQuestions();

    public Question getQuestionById(int id);

    public void deleteQuestion(Question question);

    public void addQuestion(Question question);

    public List<Question> findQuestions(String name);

    public void updateQuestion(Question question);
}
