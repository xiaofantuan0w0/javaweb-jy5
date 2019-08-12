<%--
  Created by IntelliJ IDEA.
  User: 皓珺
  Date: 2019/8/8
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品搜索</title>
</head>
<body>
    <div>
        <form action="/manage/product/search.do">
            <span>商品号：</span>
            <input type="text"  name="producId">
            <span>商品名：</span>
            <input type="text" name="productName">
            <input type="submit" value="搜索" onclick="f()">
        </form>
    </div>
</body>
<script>
    function f() {
       console.log()
    }
</script>
</html>
