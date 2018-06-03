<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
 Created by Dimple on 2018/5/26/11:59
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="alert" id="error" hidden>
    这是一个错误消息提示！
    <script>
        function checkForm() {
            var name = $("#questionQuestion").val();
            // var sex = $("#studentSex").val();
            // var idcard = $("#studentIdCard").val();
            // var prefession = $("#studentProfession").val();
            // var password = $("#studentPassword").val();
            if (name == null || name == "") {
                // $("#error").html("姓名不能为空！");
                $("#error").attr("class", "alert-danger");
                return false;
            }
            // if (sex == null || sex == "") {
            //     $("#error").html("请选择性别！");
            //     return false;
            // }
            // if (cardNo == null || cardNo == "") {
            //     $("#error").html("身份证不能为空！");
            //     return false;
            // }
            // if (prefession == null || prefession == "") {
            //     $("#error").html("专业不能为空！");
            //     return false;
            // }
            // if (password == null || password == "") {
            //     $("#error").html("密码不能为空！");
            //     return false;
            // }
            return true;
        }


    </script>
</div>
备注：未添加验证
<form action="question_add" style="width: 50%;align-self: center" onsubmit="return checkForm()">
    <div class="form-group">
        <label for="questionQuestion">问题：</label>
        <input id="questionQuestion" class="form-control" type="text" name="question">
    </div>
    <div class="form-group">
        <label for="questionCreateTime">创建时间：</label>
        <input id="questionCreateTime" class="form-control" type="date" name="createTime">
    </div>
    <div class="form-group">
        <label for="questionType">题型</label>
        <select id="questionType" name="type" class="form-control">
            <option value="">请选择题型：</option>
            <option value="1">单选题</option>
            <option value="2">多选题</option>
        </select>
    </div>
    <div class="form-group">
        <label for="questionOptionA">选项A：</label>
        <input id="questionOptionA" type="text" class="form-control" name="optionA">
    </div>
    <div class="form-group">
        <label for="questionOptionB">选项B：</label>
        <input id="questionOptionB" type="text" class="form-control" name="optionB">
    </div>
    <div class="form-group">
        <label for="questionOptionC">选项C：</label>
        <input id="questionOptionC" type="text" class="form-control" name="optionC" ">
    </div>
    <div class="form-group">
        <label for="questionOptionD">选项D：</label>
        <input id="questionOptionD" type="text" class="form-control" name="optionD">
    </div>

    <div class="form-group">
        <label for="questionAnswer">正确答案:</label>
        <input class="form-control" type="text" name="answer" id="questionAnswer">
    </div>

    <div class="form-group">
        <label for="questionPaper">所属试卷：</label>
        <select id="questionPaper" name="paper.id" class="form-control">
            <s:iterator value="%{#request.papers}" var="paper">
                <option value="<s:property value='id'/> ">
                    <s:property value="name"/>
                </option>
            </s:iterator>
        </select>
    </div>
    <button type="submit" class="btn btn-outline-primary">保存</button>
</form>