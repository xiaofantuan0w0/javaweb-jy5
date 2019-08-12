<%--
  Created by IntelliJ IDEA.
  User: 皓珺
  Date: 2019/8/9
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="dd">
    <tr>
        <td>

        </td>
    </tr>
</table>

</body>
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<script>
    $(function () {
        $.post(
            "r/list.do",
            function (dt) {
                $("#dd").text(dt);
            }
        )
    })
</script>
</html>
