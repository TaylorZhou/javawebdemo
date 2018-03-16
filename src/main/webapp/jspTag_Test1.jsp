<%--
  Created by IntelliJ IDEA.
  User: Taylor
  Date: 2018/3/1
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/taylor" prefix="test" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>输出客户端的IP</title>
</head>
<body>
你的IP地址是(使用java代码获取输出)：
<%
    //在jsp页面中使用java代码获取客户端IP地址
    String ip = request.getRemoteAddr();
    out.write(ip);
%>
<hr/>
你的IP地址是(使用自定义标签获取输出)：
<%--使用自定义标签viewIP --%>
<test:viewIP/>
</body>
</html>
