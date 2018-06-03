<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
 Created by Dimple on 2018/5/26/11:59
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="alert" id="error" hidden>
    这是一个错误消息提示！
</div>
<form action="question_update" style="width: 50%;align-self: center">
    <div class="form-group">
        <label for="questionId">ID：</label>
        <input id="questionId" type="text" class="form-control" readonly name="id" value="${question.id}">
    </div>
    <div class="form-group">
        <label for="questionQuestion">问题：</label>
        <input id="questionQuestion" class="form-control" type="text" name="question" value="${question.question}">
    </div>
    <div class="form-group">
        <label for="questionCreateTime">创建时间：</label>
        <input id="questionCreateTime" class="form-control" type="date" name="createTime"
               value="${question.createTime}">
    </div>
    <div class="form-group">
        <label for="questionType">题型</label>
        <select id="questionType" name="type" class="form-control">
            <option value="">请选择题型：</option>
            <option value="1" ${question.type=="1"?"selected":""}>单选题</option>
            <option value="2" ${question.type=="2"?"selected":""}>多选题</option>
        </select>
    </div>
    <div class="form-group">
        <label for="questionOptionA">选项A：</label>
        <input id="questionOptionA" type="text" class="form-control" name="optionA" value="${question.optionA}">
    </div>
    <div class="form-group">
        <label for="questionOptionB">选项B：</label>
        <input id="questionOptionB" type="text" class="form-control" name="optionB" value="${question.optionB}">
    </div>
    <div class="form-group">
        <label for="questionOptionC">选项C：</label>
        <input id="questionOptionC" type="text" class="form-control" name="optionC" value="${question.optionC}">
    </div>
    <div class="form-group">
        <label for="questionOptionD">选项D：</label>
        <input id="questionOptionD" type="text" class="form-control" name="optionD" value="${question.optionD}">
    </div>

    <div class="form-group">
        <label for="questionAnswer">正确答案:</label>
        <input class="form-control" type="text" name="answer" id="questionAnswer" value="${question.answer}">
    </div>
    <div class="form-group">
        <label for="questionPaper">题型</label>
        <select id="questionPaper" name="paper.id" class="form-control">
            <option value="1">请选择题型：</option>
            <%--<option value="2" ${student.sex=="2"?"selected":""}>多选题</option>--%>
        </select>
    </div>

    <button type="submit" class="btn btn-outline-primary">保存</button>

    <input type="hidden" value="${question.id}" id="hiddenId">
</form>