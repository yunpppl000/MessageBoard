<%--
  Created by IntelliJ IDEA.
  User: YEN
  Date: 2016/7/31
  Time: 17:34
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <link href="Css/style.css" rel="stylesheet" type="text/css">
    <script src="JS/jquery-1.7.1.min.js" type="text/javascript"></script>
    <script src="JS/Script.js" type="text/javascript"></script>
</head>
<body>
    <div id="loginPanel">
        <div class="form_title">用户登录</div>
        <div class="form_content">
            <ul>
                <li class="label">姓名：</li>
                <li class="input"><input type="text" id="loginName" name="loginName"></li>
            </ul>
            <ul>
                <li class="label">密码：</li>
                <li class="input"><input type="password" id="password" name="password"></li>
            </ul>
        </div>
        <div class="form_foot"><input type="submit" value="登 录" onclick="doUserLogin()"> </div>
    </div>
</body>
</html>
