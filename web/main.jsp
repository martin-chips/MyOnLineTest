<%--
 Created by Dimple on 2018/5/25/10:14
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>在线考试主界面</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- 引入CSS文件 -->
    <link rel="stylesheet" href="bootstrap-4.1.1-dist/css/bootstrap.css"/>
    <!-- 引入JQuery文件 -->
    <script src="jquery-3.3.1/jquery-3.3.1.js"></script>
    <!-- 引入BootStrap文件 -->
    <script src="bootstrap-4.1.1-dist/js/bootstrap.js"></script>
</head>
<body>
<%
    String mainPage = (String) request.getAttribute("mainPage");
    if (mainPage == null || "".equals(mainPage)) {
        mainPage = "WEB-INF/common/default.jsp";
    }
%>

<div class="container-fluid">
    <table>
        <%--显示header的界面--%>
        <tr>
            <jsp:include page="WEB-INF/common/head.jsp"/>
        </tr>
        <%--显示menu栏--%>
        <tr>
            <jsp:include page="WEB-INF/common/menu.jsp"/>
        </tr>
        <%--显示主界面--%>
        <tr>
            <jsp:include page="<%=mainPage%>"/>
        </tr>

        <tr>
            <jsp:include page="WEB-INF/common/foot.jsp"/>
        </tr>

    </table>

</div>

</body>
</html>