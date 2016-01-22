<%@page import="util.SelectByJdbc"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>欢迎</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <center>
    <h1>校园电动车管理系统（测试）</h1>
    <h2>欢迎：<%=session.getAttribute("username") %></h2>
    <h2>您的数据：
    <%=SelectByJdbc.getdata(session.getAttribute("id_weixin_tbl").toString()) %>
</h2><a href="change_data.jsp">修改数据</a>
    <h2>是否绑定了微信：<%if(SelectByJdbc.getopenid(session.getAttribute("id_weixin_tbl").toString())!=null){
    %>
    是
    <%}else{%>
    否
    <%}%>
    
    </h2>
                  <br>
        微信公众平台：<img alt="" src="weixin.jpg">
    </center>
  </body>
</html>
