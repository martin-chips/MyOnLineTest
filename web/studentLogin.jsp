<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- 引入CSS文件 -->
    <link rel="stylesheet" href="bootstrap-4.1.1-dist/css/bootstrap.css"/>
    <!-- 引入JQuery文件 -->
    <script src="jquery-3.3.1/jquery-3.3.1.js"></script>
    <!-- 引入BootStrap文件 -->
    <script src="bootstrap-4.1.1-dist/js/bootstrap.js"></script>
    <title>在线考试系统-学生登录端</title>
</head>
<body style="background: #e4ffe5">

<div class="container" style="width: 500px;margin-top: 50px">

    <%--输出提示框--%>
    <s:if test="#request.tips!=null">
        <div class="alert alert-danger alert-dismissible fade show">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <%=request.getAttribute("tips")%>
        </div>
    </s:if>

    <div class="h1 text-lg-center text-info">学生在线考试系统</div>
    <form action="student_login.action" style="margin-top: 20px" name="form" onsubmit="return checkForm()"
          method="post">
        <div class="form-group">
            <label for="student_account">学生账号：</label>
            <input type="text" class="form-control" id="student_account" name="student.id" placeholder="请输入您的账号···">
        </div>
        <div class="form-group">
            <label for="student_password">学生密码：</label>
            <input type="password" class="form-control" id="student_password" name="student.password"
                   placeholder="请输入您的密码···">
        </div>
        <div class="form-check">
            <label class="form-check-label">
                <input type="checkbox" class="form-check-input" name="isChecked" value="yes">
                <small>记住密码,请勿在公共计算机上勾选此项！</small>
            </label>
        </div>
        <input type="submit" class="btn btn-outline-primary btn-lg " style=" width: 100%;margin-top: 5px" value="登录"/>
        <button type="reset" class="btn btn-outline-danger btn-lg" style="width: 100%;margin-top: 5px">重置</button>
    </form>
</div>
<script>
    function checkForm() {
        var id = document.getElementById("student_account").value;
        var password = document.getElementById("student_password").value;
        if (id == null || id == "") {
            alert("账号不能为空！");
            return false;
        }
        if (password == null || password == "") {
            alert("密码不能为空！");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
