<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
jsp页面测试成功。${tbCS}
<table border="1px" align="center">
    <tr>
        <td>编号</td>
        <td>广告名称</td>
    </tr>
    <c:forEach items="${tbCS}" var="t">
        <tr>
            <td>${t.id}</td>
            <td>${t.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>