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
    <style type="text/css">
        #header {
            font-size: 100px;
            font-family: 方正舒体;
        }

        /* Make the image fully responsive */
        .carousel-inner img {
            width: 100%;
            height: 100%;
        }
    </style>

    <title>在线考试系统</title>
</head>
<body>
<div class="container">
    <p id="header" class="text-info  text-lg-center">学生在线考试系统</p>
    <div id="demo" class="carousel slide" data-ride="carousel">
        <!-- 指示符 -->
        <ul class="carousel-indicators">
            <li data-target="#demo" data-slide-to="0" class="active"></li>
            <li data-target="#demo" data-slide-to="1"></li>
            <li data-target="#demo" data-slide-to="2"></li>
        </ul>
        <!-- 轮播图片 -->
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="https://static.runoob.com/images/mix/img_fjords_wide.jpg">
            </div>
            <div class="carousel-item">
                <img src="https://static.runoob.com/images/mix/img_nature_wide.jpg">
            </div>
            <div class="carousel-item">
                <img src="https://static.runoob.com/images/mix/img_mountains_wide.jpg">
            </div>
        </div>
        <!-- 左右切换按钮 -->
        <a class="carousel-control-prev" href="#demo" data-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#demo" data-slide="next">
            <span class="carousel-control-next-icon"></span>
        </a>
    </div>
    <div>
        <a class="btn btn-outline-info btn-lg col" href="studentLogin.jsp" style="margin-top: 5px">学生登录</a>
        <a class="btn btn-outline-info btn-lg col" href="managerLogin.jsp" style="margin-top: 5px">管理员登录</a>
    </div>
</div>
</body>
</html>