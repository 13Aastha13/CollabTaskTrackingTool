<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.collabTool.database.object.CtUsers" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>logOut</title>
<script src="js/logout.js" type="text/javascript"></script>
</head>
<body>
<%
String CurrentCtUserName="";
CtUsers CurrentCtUser = (CtUsers) request.getSession().getAttribute("CtUser");
if (CurrentCtUser != null) 
{
  CurrentCtUserName = CurrentCtUser.getUsername();
}%>
<div id="logoutId">
<span class="logoutText">Welcome, <%= CurrentCtUserName %> &nbsp;</span>
<button id="logoutSubmit" type="button" onclick="OnLogoutClick();">Logout</button>
</div>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
</body>
</html>