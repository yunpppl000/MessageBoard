<%@ page import="Model.Message" %><%--
  Created by IntelliJ IDEA.
  User: YEN
  Date: 2016/7/31
  Time: 16:45
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改留言</title>
    <link href="Css/style.css" rel="stylesheet" type="text/css">
    <script src="JS/jquery-1.7.1.min.js" type="text/javascript"></script>
    <script src="JS/Script.js" type="text/javascript"></script>
</head>
<body style="background-color: #FFFFFF;">
    <div id="articleModifyForm">
        <div CLASS="form_title">修改帖子</div>
        <%
            Message msg=(Message)request.getAttribute("oneMessage");
        %>
        <div class="form_content">
            <ul>
                <li class="input"><textarea id="context" name="context"><%=msg.getContext()%></textarea> </li>
            </ul>
        </div>
        <div class="form_foot">
            <input type="submit" value="提交" onclick="doUpdata(<%=msg.getId()%>)">
        </div>
    </div>
</body>
</html>
