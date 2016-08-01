<%@ page import="Model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Message" %>
<%--
  Created by IntelliJ IDEA.
  User: YEN
  Date: 2016/7/31
  Time: 14:00
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>主页</title>
    <link href="Css/style.css" rel="stylesheet" type="text/css">
    <script src="JS/jquery-1.7.1.min.js" type="text/javascript"></script>
    <script src="JS/Script.js" type="text/javascript"></script>
  </head>

  <%
    int tag=-1;
    String author="";
    User user=(User)session.getAttribute("user");
    if(null!=user){
        tag=user.getTag();
        author=user.getName();
    }
  %>

  <body>

  <a name="top">     <%--设置锚点--%>
      <div id="page">

          <div id="logo" style="text-align: center; padding-top: 15px">
              <%--<img src="Images/logo.jpg">--%>
          </div>

          <div id="head">
                <div id="nav">
                    <ul>
                        <li><a href="SelectServlet">主页</a> </li>
                        <%
                            if(null==user){
                        %>
                        <li><a href="login.jsp">用户登录</a> </li>
                        <li><a href="adminlogin.jsp">管理员登录</a> </li>
                        <%
                            }
                            if(1==tag){
                        %>
                        <li><a href="SelectUserServlet">用户管理</a></li>
                        <%
                            }
                            if(null!=user){
                        %>
                        <li><a href="changePassword.jsp">修改密码</a> </li>
                        <li><a href="ExitServlet">注销</a></li>
                        <%
                            }
                        %>
                    </ul>
                </div>
          </div>
          <%--end of <div id="head">--%>

          <div id="tilte">
              <form action="SelectServlet" method="post">
                  <div class="col"><input type="submit" value="搜索"></div>
                  <div class="col"><input type="text" name="author" size="20"></div>
              </form>
          </div>
          <%--end of  <div id="tilte">--%>

          <%
              if(null != user){
          %>
          <div id="col1">
              <img src="Images/add.png" onclick="domove()">
          </div>
          <%
              }
              List<Message> messages= (List<Message>)request.getAttribute("messageList");
              if(null != messages){
                for(Message msg:messages){
          %>
          <div class="articleList">
            <ul>
                <%
                    if(null!=user){
                        if( (1==tag) || ( author.equals(msg.getAuthor()) && 0==tag )){
                %>
                <li class="func"> <img src="Images/delete.png" alt="删除" onclick="doDelete(<%=msg.getId()%>)"></li>
                <%
                    }  //end of  if( (1==tag) || ( author.equals(msg.getAuthor()) && 0==tag )){
                    if( author.equals(msg.getAuthor())){
                %>
                <li class="func"><img src="Images/edit.png" alt="编辑" onclick="jump(<%=msg.getId()%>)"></li>
                <%
                    }   //end of if( author.equals(msg.getAuthor()){
                    }   //end of if(null!=user){
                %>
                <li class="nav">
                    <strong><%=msg.getAuthor()%></strong> &nbsp;&nbsp;&nbsp;发表于<%=msg.getDate()%>
                </li>
            </ul>
              <div class="text">
                  <p><%=msg.getContext()%></p>
              </div>
          </div>
          <%
              }   //end of for(Message msg:messages){
              }
          %>

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
