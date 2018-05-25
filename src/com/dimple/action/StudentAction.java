package com.dimple.action;

import com.dimple.entity.Student;
import com.dimple.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

/**
 * Created by Dimple on 2018/5/17/17:27
 */
@Controller
@Scope(value = "prototype")
public class StudentAction extends ActionSupport{

    //    使用表达式获取表单提交的student，不能省略get和set方法，否则会丢失数据
    private Student student ;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

//    获取复选框的状态
    private String isChecked;

    public void setIsChecked(String isChecked) {
        this.isChecked = isChecked;
    }


    @Autowired
    private StudentService studentService;

    public String login() {
        System.out.println("" + student.toString());
        Student tempStudent = studentService.checkStudent(student);//获取从数据库获取的学生信息
        if (tempStudent!=null&&tempStudent.getPassword().equals(tempStudent.getPassword())) {
            student = tempStudent;
            student.setFlag(0);
            HttpSession session = ServletActionContext.getRequest().getSession();
            session.setAttribute("currentUser", student);
            session.setAttribute("flag",(int)0);//设置mainPage的头，0标识学生，1标识管理员
            return SUCCESS;
        }
        return ERROR;
    }
    public String readyUpdatePassword() {
        ServletActionContext.getRequest().setAttribute("mainPage","WEB-INF/student/updateStudentPassword.jsp");
        return SUCCESS;
    }
    /**
     * 修改学生账户密码
     * @return
     */
    public String updatePassword() {

        return NONE;

    }

    @Override
    public void validate() {

    }
}
