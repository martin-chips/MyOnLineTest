package com.dimple.action;

import com.dimple.entity.Exam;
import com.dimple.entity.Student;
import com.dimple.service.ExamService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Dimple on 2018/6/3/11:47
 */
@Controller
@Scope(value = "prototype")
public class ExamAction extends ActionSupport {
    @Autowired
    ExamService examService;
    List<Exam> exams;

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public String list(){
        exams = examService.getExamList();
        ServletActionContext.getRequest().setAttribute("mainPage", "WEB-INF/exam/examList.jsp");
        return SUCCESS;
    }

    Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String find() {
        System.out.println(student);
        exams = examService.find(student);
        ServletActionContext.getRequest().setAttribute("mainPage", "WEB-INF/exam/examList.jsp");
        return SUCCESS;
    }

    public String getExam(){
        exams = examService.find(student);
        ServletActionContext.getRequest().setAttribute("mainPage", "WEB-INF/exam/examList.jsp");
        return SUCCESS;
    }

    public String startExam(){
        ServletActionContext.getRequest().setAttribute("mainPage", "WEB-INF/exam/startExam.jsp");

        return SUCCESS;
    }
}
