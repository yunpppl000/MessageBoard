<%--
  Created by IntelliJ IDEA.
  User: YEN
  Date: 2016/7/31
  Time: 17:42
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <link href="Css/style.css" rel="stylesheet" type="text/css">
    <script src="JS/jquery-1.7.1.min.js" type="text/javascript"></script>
    <script src="JS/Script.js" type="text/javascript"></script>
</head>
<body>
    <div id="loginPanel" style="width: 300px">
        <div class="form_title">修改密码</div>
        <div class="form_content">
            <ul>
                <li class="label" style="width:65px">旧密码：</li>
                <li><input type="password" id="oldpassword" name="oldpassword"></li>
            </ul>
            <ul>
                <li class="label" style="width:65px">新密码：</li>
                <li><input type="password" id="newpassword" name="newpassword"></li>
            </ul>
            <ul>
                <li class="label" style="width:65px">确认密码：</li>
                <li><input type="password" id="repassword" name="repassword"></li>
            </ul>
        </div>
        <div class="form_foot">
            <input type="submit" value="确定" onclick="doChangePassword()">
        </div>
    </div>
</body>
</html>
