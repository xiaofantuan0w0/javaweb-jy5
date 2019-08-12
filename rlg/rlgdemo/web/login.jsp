<%--
  Created by IntelliJ IDEA.
  User: 皓珺
  Date: 2019/8/6
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
    <h1>foodie后台管理系统</h1>
    <div id="wk">
       <div id="con">
          <form action="/manage/user/login.do" id="con_form">
            <input type="text" name="username" placeholder="输入用户名" class="cf_f">
            </br>
            <input type="password" name="password" placeholder="输入密码" class="cf_f">
            </br>
            <input type="submit" value="登录" id="cf_s">
           </form>
        </div>
    </div>
    <div style="text-align:center;height: 40px;margin-top:20px ">
        <h6 style="color:darkgray;">Copyright(C)2019 www.com All Rights Reserved<br />
            张鑫粉丝后援会 版权所有 津IP备6666666号</h6>
    </div>
</body>
</html>
