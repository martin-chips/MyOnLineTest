package com.dimple.dao.impl;

import com.dimple.dao.StudentDao;
import com.dimple.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dimple on 2018/5/17/16:54
 */
@Repository
@Transactional
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
    public void addStudent(Student student) {
        hibernateTemplate.save(student);
    }

    @Override
    public void deleteStudentById(int id) {
        Student student = hibernateTemplate.get(Student.class, id);
        hibernateTemplate.delete(student);
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

    @Override
    public List<Student> listStudent() {
        List<Student> byExample = hibernateTemplate.findByExample(new Student());
        return byExample;
    }

    @Override
    public void updateStudentById(Student student) {
        int id = student.getId();
        Student tempStudent = hibernateTemplate.get(Student.class, id);
        tempStudent.setPassword(student.getPassword());
        tempStudent.setName(student.getName());
        tempStudent.setProfession(student.getProfession());
        tempStudent.setIdcard(student.getIdcard());
        tempStudent.setSex(student.getSex());
        hibernateTemplate.save(tempStudent);
    }


}
