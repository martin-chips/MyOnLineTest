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
    <link rel="stylesheet" href="../../bootstrap-4.1.1-dist/css/bootstrap.css"/>
    <!-- 引入JQuery文件 -->
    <script src="../../jquery-3.3.1/jquery-3.3.1.js"></script>
    <!-- 引入BootStrap文件 -->
    <script src="../../bootstrap-4.1.1-dist/js/bootstrap.js"></script>
    <title>在线考试系统-修改密码</title>
</head>
<body style="background: #e4ffe5">

<div class="container" style="width: 500px;margin-top: 50px">
    <div class="h1 text-lg-center text-info">修改密码</div>
    <form action="" onsubmit="return checkForm()">
        <div class="form-group">
            <label for="userId">用户ID：</label>
            <input type="text" class="form-control" id="userId" value="${currentUser.id}" readonly/>
        </div>

        <div class="form-group">
            <label for="username">用户名：</label>
            <input type="text" class="form-control" id="username" value="${currentUser.name}" readonly/>
        </div>

        <div class="form-group">
            <label for="oldPassword">原密码：</label>
            <input type="text" class="form-control" id="oldPassword"/>
        </div>

        <div class="form-group">
            <label for="newPassword">新密码：</label>
            <input type="text" class="form-control" id="newPassword" name="newPassword"/>
        </div>

        <div class="form-group">
            <label for="newPassword1">确认新密码：</label>
            <input type="text" class="form-control" id="newPassword1"/>
        </div>

        <button type="submit" class="btn btn-outline-primary" style="width: 100%;">提 交</button>
        <button type="reset" class="btn btn-outline-danger" style="width: 100%;margin-top: 3px">重 置</button>

    </form>
</div>
<script>
    function checkForm() {
        var oldPassword = $("#oldPassword").val();
        var newPassword = $("#newPassword").val();
        var newPassword1 = $("#newPassword1").val();
        if (oldPassword == null || oldPassword == "") {
            alert("请输入原密码！");
            return false;
        }
        if (oldPassword != '${currentStudent.password}') {
            alert("原密码错误，请重新输入");
            return false;
        }
        if (newPassword == null || newPassword == "") {
            alert("请输入新密码！");
            return false;
        }
        if (newPassword1 == null || newPassword1 == "") {
            alert("请输入确认新密码！");
            return false;
        }
        if (newPassword != newPassword1) {
            alert("密码输入不一致，请重新输入！");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
