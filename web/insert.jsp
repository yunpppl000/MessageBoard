<%--
  Created by IntelliJ IDEA.
  User: YEN
  Date: 2016/7/31
  Time: 17:51
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发帖</title>
    <link href="Css/style.css" rel="stylesheet" type="text/css">
    <script src="JS/jquery-1.7.1.min.js" type="text/javascript"></script>
    <script src="JS/Script.js" type="text/javascript"></script>
</head>
<body style="background-color:#FFFFFF;">
    <div id="articleModifyForm">
        <div class="form_title">发帖</div>
        <div class="form_content">
            <ul>
                <li class="input">
                    <textarea id="content" name="content"></textarea>
                </li>
            </ul>
        </div>
        <div class="form_foot">
            <input type="submit" value="发表" onclick="doInsert();">
        </div>
    </div>
</body>
</html>
