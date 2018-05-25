package com.dimple.dao.impl;

import com.dimple.dao.StudentDao;
import com.dimple.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Dimple on 2018/5/17/16:54
 */
@Repository
public class StudentDaoImpl implements StudentDao {

    //    注入hibernateTemplate
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Student getStudentById(int id) {
        Student student = hibernateTemplate.get(Student.class, id);
        return student;
    }

    @Override
    public int addStudent(Student student) {
        return 0;
    }

    @Override
    public int deleteStudent(Student student) {
        return 0;
    }

    /**
     *
     * @param student
     * @param newPassword
     * @return
     */
    @Override
    public boolean updatePassword(Student student, String newPassword) {
        // 查询出当前学生
        Student studentTemp = hibernateTemplate.get(Student.class, student.getId());
        if (student.getPassword().equals(studentTemp.getPassword())) {
            studentTemp.setPassword(newPassword);
            hibernateTemplate.update(studentTemp);
            System.out.println("修改学生密码成功");
            System.out.println("");
            return true;
        }
        System.out.println("修改学生密码失败");
        return false;
    }


}
