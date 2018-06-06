package com.dimple.service;

import com.dimple.entity.Exam;
import com.dimple.entity.Student;

import java.util.List;

/**
 * Created by Dimple on 2018/6/3/11:47
 */
public interface ExamService {
    public List<Exam> getExamList();

    public List<Exam> find(Student student);
}
