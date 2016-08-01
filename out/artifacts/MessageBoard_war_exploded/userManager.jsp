<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YEN
  Date: 2016/7/31
  Time: 17:39
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理中心</title>
    <link href="Css/style.css" rel="stylesheet" type="text/css">
    <script src="JS/jquery-1.7.1.min.js" type="text/javascript"></script>
    <script src="JS/Script.js" type="text/javascript"></script>
</head>
<body>
<a name="top">
    <div id="page">
        <div id="logo" style="text-align: center; padding-top: 15px">
            <%--<img src="Images/logo.jpg">--%>
        </div>
        <div id="head">
            <div id="nav">
                <ul>
                    <li><a href="SelectServlet">主页</a> </li>
                    <li><a href="changePassword.jsp">修改密码</a> </li>
                    <li><a href="ExitServlet">注销</a> </li>
                </ul>
            </div>
            <div id="tilte">
                <form action="SelectUserServlet" method="post">
                    <div class="col"><input type="submit" value="搜索"></div>
                    <div class="col"><input type="text" id="user" size="20"></div>
                </form>
            </div>
        </div>
        <%--end of   <div id="head">--%>

        <div><img src="Images/add.png"></div>

        <div id="func"><p><a href="addUser.jsp">添加用户</a> </p></div>

        <table id="table" bordercolor="#99CCFF" border='1px'  cellspacing='0px'>
            <tr bgcolor="#e4eef9" height="36px">
                <th>id</th>
                <th>用户名</th>
                <th>禁止发帖</th>
                <th>授权发帖</th>
                <th>删除</th>
            </tr>

            <c:forEach var="user" items="${userList}">
                <tr height="36px">
                    <th>${user.id }</th>
                    <th>${user.name }</th>
                    <th><a href="LimitServlet?id=${user.id }&tag=1">禁止发帖</a></th>
                    <th><a href="LimitServlet?id=${user.id }&tag=0">授权发帖</a></th>
                    <th><a href="DelUserServlet?id=${user.id }">删除</a></th>
                </tr>
            </c:forEach>

        </table>
        <div>
            <ul class="p2">
                <li class="p2"><a href="#top">返回顶部</a> </li>
            </ul>
        </div>
        <div id="p3">
            <p>CopyRight&nbsp;:&copy;&nbsp; YEN &nbsp;&nbsp; 2016 , All Rights Reserved</p>
        </div>
    </div>
</a>
</body>
</html>
