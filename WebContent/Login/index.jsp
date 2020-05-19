<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>文档管理平台</title>
    <!-- for-mobile-apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- //for-mobile-apps -->
    <link href="<%=basePath%>Login/css/style.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
    <!-- main -->
    <div class="main">
        <h1>文档管理平台</h1>
        <form action="<%=basePath%>/begin" method="post">
            <input type="text" name="username" value="admin" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '用户名';}"
                   required="">
            <input type="password" name="password" value="admin123" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '';}"
                   required="">
            <input type="submit" value="登录">
        </form>
    </div>
    <div class="footer">
        <p>
            <!-- &copy 2016 Welcome Login Form. All rights reserved  更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a> -->
        </p>
    </div>
    <!-- //main -->
</body>
</html>