<%--
  Created by IntelliJ IDEA.
  User: YEN
  Date: 2016/7/31
  Time: 21:27
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
    <link href="Css/style.css" rel="stylesheet" type="text/css">
    <script src="JS/jquery-1.7.1.min.js" type="text/javascript"></script>
    <script src="JS/Script.js" type="text/javascript"></script>
</head>
<body>
<div id="loginPanel" style="width: 270px">
    <div class="form_title">添加用户</div>
    <div class="form_content">
        <ul>
            <li class="label" style="margin-left: 18px">用户名:</li>
            <li class="input" style="margin-left: 0px"><input id="loginName" type="text" name="loginName" /></li>
        </ul>
        <ul>
            <li class="label" style="margin-left: 20px">密码:</li>
            <li class="input"><input id="password1" type="password"name="password1" /></li>
        </ul>
        <ul>
            <li class="label" style="width: 60px">确认密码:</li>
            <li class="input"><input id="password2" type="password"name="password2" /></li>
        </ul>
    </div>
    <div class="form_foot">
        <input type="submit" value=" 保 存 " onclick="doAddUser();" />
    </div>
</body>
</html>
