<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/2
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>登录</title>
</head>
<body>
<c:if test="${!empty errorMsg}">
    <div style="color:#ff0000">${errorMsg}</div>
</c:if>
<form action="${context}/user/dologin" method="post">
    <table border="1px" width="100%">
        <tr>
            <td width="20%">用户名</td>
            <td width="80%"><input type="text" name="userName"/></td>
        </tr>
        <tr>
            <td width="20%">密码</td>
            <td width="80%"><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="登录">
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
