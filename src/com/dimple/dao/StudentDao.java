package com.dimple.dao;

import com.dimple.entity.Student;

/**
 * Created by Dimple on 2018/5/17/16:45
 */

public interface StudentDao {
    //    根据ID获取学生的信息
    public Student getStudentById(int id);

    //     添加学生信息
    public int addStudent(Student student);

    //    删除学生信息
    public int deleteStudent(Student student);

    //    修改密码
    public boolean updatePassword(Student student,String newPassword);


}
