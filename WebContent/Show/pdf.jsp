<%@ page language="java" import="java.util.*,java.io.*"
pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
    + request.getServerName() + ":" + request.getServerPort()
    + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   <base href="<%=basePath%>">
</head>
<%
   String url=request.getParameter("url");
   out.clear();
   out = pageContext.pushBody();
   response.setContentType("application/pdf");

   try {
	String strPdfPath = new String(url);
    //String strPdfPath = new String("D:/1.华高工作整理/3.胶州二期智能交通/8.CMMI管理/1 组织级工作目录/02-组织工作库/06_培训库/03_教材库/10-风险管理RSKM/nasarisk.pdf");
    //判断该路径下的文件是否存在
    File file = new File(strPdfPath);
    if (file.exists()) {
     DataOutputStream temps = new DataOutputStream(response
       .getOutputStream());
     DataInputStream in = new DataInputStream(
       new FileInputStream(strPdfPath));

     byte[] b = new byte[2048];
     while ((in.read(b)) != -1) {
      temps.write(b);
      temps.flush();
     }

     in.close();
     temps.close();
    } else {
     out.print(strPdfPath + " 文件不存在!");
    }

   } catch (Exception e) {
    out.println(e.getMessage());
   }
%>
<body>
   <br>
</body>
</html>