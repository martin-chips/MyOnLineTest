package com.dimple.service.impl;

import com.dimple.dao.ExamDao;
import com.dimple.entity.Exam;
import com.dimple.entity.Student;
import com.dimple.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dimple on 2018/6/3/11:47
 */
@Service
@Transactional
public class ExamServiceImpl implements ExamService {

    @Autowired
    ExamDao examDao;

    @Override
    public List<Exam> getExamList() {
        return examDao.getExamList();
    }

    @Override
    public List<Exam> find(Student student) {
        List<Exam> list = new ArrayList<>();
        List<Exam> examList = getExamList();
        //解决前台传入的student.name的属性值为null的情况，减少判断
        if (student.getName() == null) {
            student.setName("");
        }
        if (student == null) {
            return null;
        } else if (student.getId() == null && "".equals(student.getName())) {
            //表示无输入，这时应该是返回所有的记录
            return getExamList();
        } else if (student.getId() != null && "".equals(student.getName())) {//处理只输入ID的情况
            for (Exam exam : examList) {
                if (exam.getStudent().getId() == student.getId()) {
                    list.add(exam);
                }
            }
        } else if (student.getId() == null && !"".equals(student.getName())) {//处理只输入姓名的情况
            for (Exam exam : examList) {
                if (exam.getStudent().getName().equals(student.getName())) {
                    list.add(exam);
                }
            }
        } else {//处理两个都输了的情况
            for (Exam exam : examList) {
                if (exam.getStudent().getName().equals(student.getName()) && exam.getStudent().getId() == student.getId()) {
                    list.add(exam);
                }
            }
        }
        return list;
    }
}
