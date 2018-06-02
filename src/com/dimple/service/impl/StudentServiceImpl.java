package com.dimple.service.impl;

import com.dimple.dao.StudentDao;
import com.dimple.entity.Student;
import com.dimple.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
     *
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
     *
     * @param student
     */
    @Override
    public Student updatePassword(Student student, String newPassword) {
        if (studentDao.updatePassword(student, newPassword)) {
            student.setPassword(newPassword);
        }
        return student;
    }

    @Override
    public List<Student> listStudent() {
        return studentDao.listStudent();
    }

    @Override
    public Student getStudentById(int id) {
        if (id == 0) {
            return null;
        }
        Student studentById = studentDao.getStudentById(id);
        return studentById;

    }

    @Override
    public void updateStudentById(Student student) {
        if (student.getId() == 0) {
            return;
        }
        studentDao.updateStudentById(student);
    }

    @Override
    public void deleteStudentById(int id) {
        if (id != 0) {
            studentDao.deleteStudentById(id);
        }
    }

    @Override
    public void addStudent(Student student) {
        if (student != null) {
            studentDao.addStudent(student);
        }
    }

    @Override
    public List<Student> findStudent(Student student) {
        List<Student> students;
        if (student.getId() == 0 && "".equals(student.getName())) {
            return listStudent();
        } else if (student.getId() != 0 && "".equals(student.getName())) {
            students = new ArrayList<>();
            students.add(getStudentById(student.getId()));
            return students;
        }
        return studentDao.getStudentByName(student.getName());
    }
}
