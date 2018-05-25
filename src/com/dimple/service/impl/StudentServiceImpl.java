package com.dimple.service.impl;

import com.dimple.dao.StudentDao;
import com.dimple.entity.Student;
import com.dimple.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dimple on 2018/5/17/17:17
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    /**
     * 根据表单输入的Student对象来检查是否是正确的学生
     * @param student（表单传入的学生）
     * @return 是否是合法的学生
     */
    @Override
    public Student checkStudent(Student student) {
//        根据传入的id获取学生信息。
        Student studentById = studentDao.getStudentById(student.getId());
        return studentById;
    }

    /**
     * 修改学生账户密码
     * @param student
     */
    @Override
    public void updatePassword(Student student) {

    }
}
