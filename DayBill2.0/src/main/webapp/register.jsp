<% String path= request.getContextPath(); %> <%--获取根路径--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>天天记账</title>
    <meta http-equiv="Content-type" content="text/html ;chareat=utf-8"/>
    <meta name="viewport" content="width=device-width, user-scalable=no,initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="register.css">
</head>
<body>
<!--中间的表单-->
<div id="son">
    <form id="form" action="<%=path%>/register" method="POST">
        <legend>
            <span >register</span>
        </legend>
        <p>
            <%--回显账号已存在--%>${no}
                <%--回显注册成功--%>${yes}
            <label>用户名:</label>
            <input type="text" size="30" maxlength="14" minlength="3" id="username" name="username" value="${username}" placeholder="请输入用户名">
        </p>
        <p>
            <label>密码:</label>
            <input type="password" size="30" maxlength="20"minlength="8" id="password" name="password" placeholder="请输入密码">
        </p>
        <p>
        </p>
        <p>
            <button type="button" name="RegisterButton" onclick="registerverify()">注册</button>
            <button type="button" name="LoginButton" onclick="loginbutton()">登录</button>
    </form>
</div>

</body>
</html>
<script>
    /* click按钮调用onclick 判断情况*/
    function registerverify(){
        var username =document.getElementById("username").value;
        var password =document.getElementById("password").value;
        if(username == ""){
            alert("用户名不能为空！")
            return;
        }
        if(password == ""){
            alert("密码不能为空！")
            return;
        }
        if(password.length<8){
            alert("密码必须大于等于8位！")
            return;
        }
        if(username.length<3){
            alert("用户名必须大于等于3位！")
            return;
        }

        // 调用后端servlet 并将数据进行传递
        document.getElementById("form").submit();
    }
</script>
<script>
    function loginbutton(){
        window.location.href='login.jsp'
    }
</script>