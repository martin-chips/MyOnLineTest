package com.dimple.dao;

import com.dimple.entity.Exam;

import java.util.List;

/**
 * Created by Dimple on 2018/6/3/11:48
 */
public interface ExamDao {
    public Exam getExamById(int id);

    public List<Exam> getExamList();

    public Exam getExam();
}
