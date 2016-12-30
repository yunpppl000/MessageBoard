# MessageBoard
基本完成
Jsp+Servlet+JavaBean学习阶段的一个案例总结

 - 名称：留言板(MessageBoard)
 - 开发技术：Jsp+Servlet+JavaBean
 - 数据库：Mysql
 - 开发工具：IntelliJ IDEA 2016.1.3
 - 服务器：Tomcat 8.0.36


----------


**功能说明**
普通用户：增加删除修改留言信息
管理员：增加删除修改留言信息、管理用户、设置用户发帖留言权限


----------


 **数据库结构**
 
 ***tb_user表***
 
 |  字段  |   类型  |   名称  |   说明  |

 |  id  |   int |   id  |
 
 |  name    |   nvarchar    |   姓名  |
 
 |  password    |   nvarchar    |   密码  |
 
 |  limit   |   int |   权限  |   0:允许发言   1:禁止发言 |
 
 |  tag |   int |   标签  |   0:用户       1:管理员    |
 


***tb_message表***

 |  字段  |   类型  |   名称  |   说明  |
 

 |  id  |   int |   id  |
 
 |  author  |   nvarchar    |   作者  |
 
 |  context |   nvarchar    |   留言内容    |
 
 |  msgdate |   datetime    |   留言时间    |
 



----------

**结构**

***总体结构***

![这里写图片描述](http://img.blog.csdn.net/20160801124122806)


![这里写图片描述](http://img.blog.csdn.net/20160801124206509)

***src结构***

![这里写图片描述](http://img.blog.csdn.net/20160801124256525)

***web结构***

![这里写图片描述](http://img.blog.csdn.net/20160801124402727)


----------

登录前的界面：
![image](https://github.com/YEN-GitHub/MessageBoard/blob/master/Img/1.png)

登录后的界面：
![image](https://github.com/YEN-GitHub/MessageBoard/blob/master/Img/2.png)

----------


