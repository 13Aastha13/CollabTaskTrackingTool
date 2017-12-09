package com.collabTool.main;


import java.net.URL;


public class CtConstants //extends HttpServlet 
{
	static
	{
		//gets path of the DB Conf file dynamically
		URL fclassesRootDir=new CtConstants().getClass().getProtectionDomain().getCodeSource().getLocation();
		classesRootDir=fclassesRootDir.toString().substring(6);
		
	}
	// DB Tables Names
    public static final String DB_Ct_UserTable="ct_users";
    static String classesRootDir ;
    
    //String path = getServletContext().getRealPath("WEB-INF/../");
   // public static final String DB_Conf_File="D:\\Assignments\\CollabTaskTrackingTool\\Br_Configurations\\DBParameter.conf";
    public static final String DB_Conf_File =classesRootDir+"\\..\\..\\DB_Configurations\\DBParameter.conf";
    public static final int  MAX_TIMEOUT= 7200;

	public static final String DB_Ct_UserTaskTable = "ct_users_tasks";

	public static final String DB_Ct_TaskTable = "ct_tasks";

}
