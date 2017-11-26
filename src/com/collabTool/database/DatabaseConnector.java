package com.collabTool.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


import com.collabTool.main.CtConstants;
import com.mysql.jdbc.Connection;

public class DatabaseConnector
{
	    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	    private String DB_URL = "";
	    private String USER = "";
	    private String PASS = "";
	    private Connection conn = null;
	    
	    public static DatabaseConnector dc = new DatabaseConnector();
	    public static DatabaseConnector getInstance()
	    {
	    	return dc;
	    }
	    public static synchronized Connection getConnection()
	    { 
	    	getInstance().getDBParameters();
	    	getInstance().connect();
	    	return(getInstance().conn);
	    	
	    }
	    private void connect() 
	    {
	       
	        try {
	            Class.forName(JDBC_DRIVER);
	            System.out.println("Connecting to database...");
	            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
	            
	            if (conn != null && !conn.isClosed())
	            {
	                System.out.println("Connected successfully...");
	            }
	        } catch (ClassNotFoundException e) 
	        {
	            System.err.println("Class Not Found Error :: " + e.getMessage());
	        } catch (SQLException e)
	        {
	            System.err.println("DatabaseConnector :: connect() :: SQL Error :: " + e.getMessage());
	        }
	    }
	    private void getDBParameters()
	    {
	    	Properties dbConfProperties = new Properties();
	        try 
	        {
	        	
			dbConfProperties.load(new FileInputStream(CtConstants.DB_Conf_File));
			USER=dbConfProperties.getProperty("db_user");
			PASS=dbConfProperties.getProperty("db_pw");
			DB_URL = "jdbc:mysql://"+ dbConfProperties.getProperty("server_ip")+ ":" + dbConfProperties.getProperty("server_port") + "/"+ dbConfProperties.getProperty("db_name") +"?autoReconnect=true";
			
	        }
	        catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    	
	       
	    }
}
