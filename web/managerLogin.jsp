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
    <div class="h1 text-lg-center text-info">学生在线考试系统——管理员登录</div>

    <form action="manager_login.action" style="margin-top: 20px" name="form" method="post">
        <div class="form-group">
            <label for="manager_account">账号：</label>
            <input type="text" class="form-control" id="manager_account" name="id" placeholder="请输入您的账号···">
        </div>
        <div class="form-group">
            <label for="manager_password">密码：</label>
            <input type="password" class="form-control" id="manager_password" name="password"
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

</body>
</html>