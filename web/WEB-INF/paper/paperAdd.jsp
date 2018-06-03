<%--
 Created by Dimple on 2018/5/26/21:31
--%>
<script>
    function checkForm() {
        var name = $("#studentName").val();
        if (name == null || name == "") {
            // $("#error").html("姓名不能为空！");
            $("#error").attr("class", "alert-danger");
            return false;
        }
        return true;
    }

</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="paper_add" style="width: 50%;align-self: center" onsubmit="return checkForm()">

    <div class="form-group">
        <label for="studentName">试卷名称：</label>
        <input id="studentName" class="form-control" type="text" name="name" value="${paper.name}" >
    </div>
    <button type="submit" class="btn btn-outline-primary">保存</button>
</form>