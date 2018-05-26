package com.dimple.action;

import com.dimple.entity.Student;
import com.dimple.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Dimple on 2018/5/17/17:27
 */
@Controller
@Scope(value = "prototype")
public class StudentAction extends ActionSupport {
    //    修改学生账号的界面传递过来的值
    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    //    使用表达式获取表单提交的student，不能省略get和set方法，否则会丢失数据
    private Student student;

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
        if (tempStudent != null && tempStudent.getPassword().equals(student.getPassword())) {
            student = tempStudent;
            HttpSession session = ServletActionContext.getRequest().getSession();
            session.setAttribute("currentUser", student);
            session.setAttribute("flag", (int) 0);//设置mainPage的头，0标识学生，1标识管理员
            return SUCCESS;
        }
        ServletActionContext.getRequest().setAttribute("tips", "请检查账号或者密码是否输入错误！");
        return ERROR;
    }

    public String readyUpdatePassword() {
        ServletActionContext.getRequest().setAttribute("mainPage", "WEB-INF/student/updateStudentPassword.jsp");
        return SUCCESS;
    }

    /**
     * 修改学生账户密码
     *
     * @return
     */
    public String updatePassword() {
        Student currentUser = (Student) ServletActionContext.getRequest().getSession().getAttribute("currentUser");
        Student student = studentService.updatePassword(currentUser, newPassword);
        //更新session中的currentUser的值，防止用户两次修改密码导致的修改密码失败
        ServletActionContext.getRequest().getSession().setAttribute("currentUser", student);
        ServletActionContext.getRequest().setAttribute("mainPage", "WEB-INF/student/updatePasswordSuccess.jsp");
        return SUCCESS;
    }

    public String logout() {
        //invalidate，使所有的session范围的对象失效（清空），注意此处不是清空所有的值
        ServletActionContext.getRequest().getSession().invalidate();
        return "logout";
    }

    List<Student> list;

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public String list() {
        list = studentService.listStudent();
//        ServletActionContext.getRequest().getSession().setAttribute("studentList", students);
        ServletActionContext.getRequest().setAttribute("mainPage", "WEB-INF/student/studentList.jsp");
        return SUCCESS;
    }

    @Override
    public void validate() {
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String readyUpdate() {
        Student studentById = studentService.getStudentById(id);
        if (studentById != null) {
            ServletActionContext.getRequest().setAttribute("mainPage", "WEB-INF/student/studentUpdate.jsp");
            ServletActionContext.getRequest().setAttribute("student", studentById);
            return SUCCESS;
        }
        return SUCCESS;
    }

    public String update() {
        studentService.updateStudentById(student);
        return "updateSuccess";
    }

    public String delete() {

        studentService.deleteStudentById(id);
        return "updateSuccess";

    }

    public String readyAdd(){
        ServletActionContext.getRequest().setAttribute("mainPage", "WEB-INF/student/studentAdd.jsp");
        return SUCCESS;
    }
    public String add(){

        studentService.addStudent(student);
        return "updateSuccess";
    }
}
