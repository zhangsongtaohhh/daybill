<%--
  Created by IntelliJ IDEA.
  User: bright
  Date: 2021/6/10
  Time: 1:57 下午
  To change this template use File | Settings | File Templates.
--%>
<% String path= request.getContextPath(); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>登陆界面</title>
    <meta http-equiv="Content-type" content="text/html ;chareat=utf-8"/>
    <meta name="viewport" content="width=device-width, user-scalable=no,initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="login.css">
</head>
<body>
<!--中间的表单-->
<div id="son">
    <form id="form" action="<%=path%>/loginServlet" method="POST">
        <legend>
            <span >login</span>
        </legend>
        <p>
            ${error}
            <label>用户名:</label>
            <input type="text" size="30" maxlength="14" minlength="3" id="username" name="username" value="${username}" placeholder="请输入用户名">
        </p>
        <p>
            <label>密码:</label>
            <input type="password" size="30" maxlength="20"minlength="8" id="password" name="password" placeholder="请输入密码">
        </p>
        <p>
            <span class="remember"> 记住密码</span>
            <input type="checkbox" name="checkbox1" value="checkbox" >
            <a href="#" target="_blank" class="register">点此注册>> </a><br>
            <a href="#" target="_blank" class="register">游客访问>> </a>

        </p>
        <p>
            <button type="button" name="loginButton" onclick="loginverify()">click</button>
            <button class="reset" type="reset" >Reset</button>
    </form>
</div>

</body>
</html>
<script>
    function loginverify(){
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
            alert("密码必须大于8位！")
            return;
        }
        // 调用后端servlet 并将数据进行传递
        document.getElementById("form").submit();
    }
</script>