<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
 Created by Dimple on 2018/5/26/11:59
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="text-info">试题管理</div>

<button class="btn btn-outline-primary" style="float: right;" type="button"
        onclick="window.location.href='question_readyAdd'">添加试题信息
</button>

<form action="question_find" method="post">
    <div class="form-group">
        <label for="questionFind">考试题目（模糊查询）</label>
        <input id="questionFind" type="text" name="findName">
    </div>
    <button type="submit" class="btn btn-outline-primary">查询</button>
</form>

<%--显示信息表格--%>
<table class="table table-hover">
    <thead>
    <tr>
        <th>序号</th>
        <th>试题题目</th>
        <th>试题加入时间</th>
        <th>题目类型</th>
        <th>所属试卷</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>

    <s:iterator value="questions" var="question">

        <tr>
            <td><s:property value="#question.id"/></td>
            <td><s:property value="#question.question"/></td>
            <td>
                <s:date name="%{#question.createTime}" format="yyyy年MM月dd日"/>
            </td>
            <td>
                <s:if test="#question.type==1">
                    单选题
                </s:if><s:elseif test="#question.type==2">
                多选题
            </s:elseif><s:else>
                其他
            </s:else>
            </td>
            <td><s:property value="#question.paper.name"/></td>
            <td>
                <button class="btn btn-outline-secondary"
                        onclick="window.location.href='question_showQuestionInfo?id=${id}'">查看试题
                </button>
                <button class="btn btn-outline-secondary"
                        onclick="window.location.href='question_readyUpdate?id=${id}'">修改
                </button>
                <a href="question_delete?id=${id}" class="btn btn-outline-danger" id="delete">删除</a>
                <input type="hidden" value="${question}">
            </td>
        </tr>
    </s:iterator>
    </tbody>

    <script>
        $(function () {
            $("#delete").click(function () {
                var question = $(this).next(":input").val();
                var flag = confirm("你确定要删除" + question + "的信息吗？");
                if (flag) {
                    return true;
                }
                return false;
            })
        })
    </script>
</table>


