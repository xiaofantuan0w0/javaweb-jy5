<%--
  Created by IntelliJ IDEA.
  User: 皓珺
  Date: 2019/8/7
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>商品列表</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/productlist.css">
</head>
<body>
${pli}
<div id="wk">
    <table id="table">
        <tr id="tbl">
            <th>商品名</th>
            <th>商品ID</th>
            <th>图片</th>
            <th>上架状态</th>
            <th>促销信息</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pli.data}" var="ps">
            <tr id="sjl">
                <td>${ps.pname} </td>
                <td>${ps.pid}</td>
                <td>${ps.mainImage} </td>
                <td>${ps.stats} </td>
                <td>${ps.cuxiao} </td>
                <td>${ps.categoryId}</td>
                <td id="sx">
                    <a href="/manage/product/set_sale_status.do?producId=${ps.pid}&status=0" id="kq" >上架</a>
                    <a href="/manage/product/set_sale_status.do?producId=${us.uid}&status=1" id="jy">下架</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    </div>
</body>
<script>

</script>
</html>
