package com.collabTool.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.collabTool.database.dao.CtTaskCollector;
import com.collabTool.database.object.CtTasks;
import com.google.gson.Gson;


@WebServlet("/TaskCollectorServlet")
public class TaskCollectorServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<CtTasks> lbu=null;
		String userId=request.getParameter("userId");
		String action=request.getParameter("action");
		PrintWriter out = response.getWriter();
		//response.setContentType("text/html;charset=UTF-8");
		if(action.equals("getTasks"))
		{
			lbu=CtTaskCollector.getMyTasks(Integer.parseInt(userId));
			response.setContentType("application/json");
			new Gson().toJson(lbu, out);

		}

	}}
