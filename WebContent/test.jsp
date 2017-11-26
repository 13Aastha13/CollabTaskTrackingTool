<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<% 
String CurrentCtUser=request.getSession().getAttribute("CtUser").toString();
boolean  me = request.getSession().isNew();
String me2=request.getSession().getId();
%>
<h1>Welcome <%=CurrentCtUser%> <%=me2 %> </h1>
</body>
</html>