package com.dimple.service;

import com.dimple.entity.Student;

/**
 * Created by Dimple on 2018/5/17/17:16
 */

public interface StudentService {

    //    根据Action传过来的信息检查是否存在当前学生
    public Student checkStudent(Student student);

}
