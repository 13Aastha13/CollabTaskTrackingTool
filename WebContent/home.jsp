<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.collabTool.database.object.CtUsers" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%
	String CurrentCtUserName ="";
	if (request.getSession(false) == null)
	{
		response.sendRedirect(request.getContextPath()+"/index.html");

	} 
	else {
		//BrUsers CurrentBrUser = (BrUsers) request.getSession().getAttribute("BrUser");
	    //CurrentBrUserName = CurrentBrUser.getUsername();%>
	    <div style="display: inline-block; position:absolute; right:0px; top:0px; 
	    text-align:right;vertical-align:top;z-index:1000; margin:5px 5px 10px;">
	    <jsp:include page="logoutPage.jsp"></jsp:include>
	    </div>
	    <jsp:include page="TaskContainer.jsp"></jsp:include>
	    
	<%}%>

</body>
</html>