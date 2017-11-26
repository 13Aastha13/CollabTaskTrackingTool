package com.collabTool.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.StyledEditorKit.BoldAction;


import com.collabTool.database.dao.CtUsersDao;
import com.collabTool.database.object.CtUsers;
import com.collabTool.main.CtConstants;

/**
 * Servlet implementation class SecurityServlet
 */
//@WebServlet("/SecurityServlet")
public class SecurityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecurityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String email=request.getParameter("email");
		String action=request.getParameter("action");
		String password=request.getParameter("password");
		PrintWriter out = response.getWriter();
		//response.setContentType("text/html;charset=UTF-8");
		if(action.equals("login"))
		{
			List<CtUsers> lbu =CtUsersDao.getUser(email, password);
			if(lbu.size()==1)
			{
			
				HttpSession mySession = request.getSession();
				mySession.setMaxInactiveInterval(CtConstants.MAX_TIMEOUT);
				mySession.setAttribute("CtUser", lbu.get(0));
				out.print("SUCCESS");
				//String BrName=lbu.get(0).getUsername();
				//RequestDispatcher rdp= request.getRequestDispatcher("../../../../../WebContent/home.jsp");
				// RequestDispatcher rdp=  getServletContext().getRequestDispatcher("/home.jsp");
				//rdp.forward(request, response);
				
			}

			/*if(email.equalsIgnoreCase("aastha.singhal@alstom.com")&& password.equals("Albus13#"))
			{
			
				HttpSession mySession = request.getSession();
				mySession.setMaxInactiveInterval(BrConstants.MAX_TIMEOUT);
				mySession.setAttribute("BrUser", "Aastha");
				//String BrName=lbu.get(0).getUsername();
				//RequestDispatcher rdp= request.getRequestDispatcher("../../../../../WebContent/home.jsp");
				 //RequestDispatcher rdp=  getServletContext().getRequestDispatcher("/test.jsp");
				//rdp.forward(request, response);
				//response.sendRedirect(request.getContextPath()+"/test.jsp");
				//return;
			}*/
			else 
			{
				out.print("FAILURE");
			}
			
		}
		else if("logout".equalsIgnoreCase(action))
		{

			CtUsers CurrentCtUser = (CtUsers) request.getSession().getAttribute("CtUser");
			System.out.println("Logout was requested by username : ["+ CurrentCtUser.getUsername() + "]");

			
			request.getSession().invalidate();
		}



	}}
