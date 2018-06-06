<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
 Created by Dimple on 2018/5/26/11:59
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="text-info">试题管理</div>
<%--如果是管理员登录的情况--%>
<s:if test="#session.flag==1">
    <form action="exam_find" method="post">
        <div class="form-group">
            <label for="StudentId">学生ID</label>
            <input id="StudentId" type="text" name="student.id">
        </div>
        <div class="form-group">
            <label for="studentName">学生姓名</label>
            <input id="studentName" type="text" name="student.name" value="">
        </div>
        <button type="submit" class="btn btn-outline-primary">查询</button>
    </form>
</s:if>

<%--显示信息表格--%>
<table class="table table-hover">
    <thead>
    <tr>
        <th>序号</th>
        <th>考生ID</th>
        <th>考生姓名</th>
        <th>试卷名称</th>
        <th>考试日期</th>
        <th>单选题得分</th>
        <th>多选题得分</th>
        <th>总分</th>
    </tr>
    </thead>
    <tbody>
    <s:iterator value="exams" var="exam">
        <tr>
            <td><s:property value="#exam.id"/></td>
            <td><s:property value="#exam.student.id"/></td>
            <td><s:property value="#exam.student.name"/></td>
            <td><s:property value="#exam.paper.name"/></td>
            <td>
                <s:date name="%{#exam.examDate}" format="yyyy年MM月dd日"/>
            </td>
            <td><s:property value="#exam.singleScore"/></td>
            <td><s:property value="#exam.moreScore"/></td>
            <td><s:property value="#exam.moreScore"/>+<s:property value="#exam.singleScore"/></td>
        </tr>
    </s:iterator>
    </tbody>
</table>


