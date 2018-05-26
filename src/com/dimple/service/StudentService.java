package com.dimple.service;

import com.dimple.entity.Student;

import java.util.List;

/**
 * Created by Dimple on 2018/5/17/17:16
 */

public interface StudentService {

    //    根据Action传过来的信息检查是否存在当前学生
    public Student checkStudent(Student student);

    //    更新学生密码
    public Student updatePassword(Student student, String newPassword);


    public List<Student> listStudent();

    public Student getStudentById(int id);

    //    根据ID修改学生信息
    public void updateStudentById(Student student);

    public void deleteStudentById(int id);

    public void addStudent(Student student);
}
