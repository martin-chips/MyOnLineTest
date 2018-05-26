<%--
 Created by Dimple on 2018/5/26/21:31
--%>
<script>
    function checkForm() {
        var name = $("#studentName").val();
        var sex = $("#studentSex").val();
        var idcard = $("#studentIdCard").val();
        var prefession = $("#studentProfession").val();
        var password = $("#studentPassword").val();
        if (name == null || name == "") {
            // $("#error").html("姓名不能为空！");
            $("#error").attr("class", "alert-danger");
            return false;
        }
        if (sex == null || sex == "") {
            $("#error").html("请选择性别！");
            return false;
        }
        if (cardNo == null || cardNo == "") {
            $("#error").html("身份证不能为空！");
            return false;
        }
        if (prefession == null || prefession == "") {
            $("#error").html("专业不能为空！");
            return false;
        }
        if (password == null || password == "") {
            $("#error").html("密码不能为空！");
            return false;
        }
        return true;
    }



</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="student_add" style="width: 50%;align-self: center" onsubmit="return checkForm()">

    <div class="form-group">
        <label for="studentName">姓名：</label>
        <input id="studentName" class="form-control" type="text" name="student.name" >
    </div>
    <div class="form-group">
        <label for="studentSex">性别：</label>
        <select id="studentSex" name="student.sex" class="form-control">
            <option value="">请选择性别</option>
            <option value="男" >男</option>
            <option value="女" >女</option>
        </select>
    </div>
    <div class="form-group">
        <label for="studentIdCard">身份证号码：</label>
        <input id="studentIdCard" type="text" class="form-control" name="student.idcard">
    </div>
    <div class="form-group">
        <label for="studentProfession">专业:</label>
        <input class="form-control" type="text" name="student.profession" id="studentProfession">
    </div>

    <div class="form-group">
        <label for="studentPassword">密码：</label>
        <input id="studentPassword" type="text" class="form-control" name="student.password">
    </div>


    <button type="submit" class="btn btn-outline-primary">保存</button> >
</form>