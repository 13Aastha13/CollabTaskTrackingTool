<%@page import="com.collabTool.database.dao.CtTaskCollector"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.collabTool.database.object.CtUsers" %>
    <%@ page import="com.collabTool.database.object.CtTasks" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/taskCollector.js" type="text/javascript"></script>
</head>
<body>
<%
int CurrentCtUserId=0;
List<CtTasks> lbu=null;
CtUsers CurrentCtUser = (CtUsers) request.getSession().getAttribute("CtUser");
if (CurrentCtUser != null) 
{
  CurrentCtUserId = CurrentCtUser.getUserid();
  //lbu =CtTaskCollector.getMyTasks(CurrentCtUserId);
}%>
<%//=lbu.toString() %>
<button id="userId" value="<%=CurrentCtUserId%>" style="display:none;"></button>
<script> OnRefreshClick();</script>
<div id="refreshMe">
<button type="button" onclick="OnRefreshClick();">Refresh</button>
<!--<button type="button" onclick="CreateTableFromJSON();">Refresh</button>-->
</div>
<div id="showData"></div>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
</body>
</html>