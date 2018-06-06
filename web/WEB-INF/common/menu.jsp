<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<script>
    // 学生退出登录
    function studentLogout() {
        if (confirm("您确定要退出系统吗？")) {
            window.location.href = 'student_logout';
        }
    }

    //管理员退出系统
    function adminLogout() {
        if (confirm("您确定要退出系统吗？")) {
            window.location.href = "manager_logout";
        }
    }
</script>

<nav class="navbar navbar-expand-lg bg-info navbar-dark justify-content-center" style="margin-top: 5px">
    <ul class="navbar-nav" style="width: 100%">
        <%--为1表示是管理员登录--%>
        <s:if test="#session.flag==1">
            <li class="nav-item"><a class="nav-link" href="main.jsp">首页</a></li>
            <li class="nav-item"><a class="nav-link" href="student_list"> 考生信息管理</a></li>
            <li class="nav-item"><a class="nav-link" href="exam_list"> 考生成绩管理</a></li>
            <li class="nav-item"><a class="nav-link" href="paper_list"> 试卷管理</a></li>
            <li class="nav-item"><a class="nav-link" href="question_list"> 题目管理</a></li>
            <li class="nav-item"><a class="nav-link" href="manager_readyUpdatePassword"> 修改密码</a></li>
            <li class="nav-item"><a class="nav-link" href="javascript:adminLogout()"> 退出系统</a></li>
        </s:if>
        <%--为其他表示是学生登陆--%>
        <s:elseif test="#session.flag==0">
            <li class="nav-item"><a class="nav-link" href="main.jsp">首页</a></li>
            <li class="nav-item"><a class="nav-link" href="paper_listSelect"> 在线考试</a></li>
            <li class="nav-item"><a class="nav-link" href="exam_getExam?student.id=${currentUser.id}"> 成绩查询</a></li>
            <li class="nav-item"><a class="nav-link" href="student_readyUpdatePassword"> 修改密码</a></li>
            <li class="nav-item"><a class="nav-link" href="javascript:studentLogout()"> 退出系统</a></li>
        </s:elseif>
        <s:else>
            <script>
                alert("您不是合法用户，请退出！");
                window.location.href = "index.jsp";
            </script>
        </s:else>
    </ul>
</nav>
