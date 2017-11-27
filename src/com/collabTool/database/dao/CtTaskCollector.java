package com.collabTool.database.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;


import com.collabTool.database.object.CtTasks;

import com.collabTool.main.CtConstants;

@SuppressWarnings("rawtypes")
public class CtTaskCollector extends BaseDao
{
	public static CtTaskCollector me=new CtTaskCollector();
	@SuppressWarnings("unchecked")
	public static List<CtTasks> getMyTasks(int userId)
	{
		String sql= "select * from " +  CtConstants.DB_Ct_TaskTable + " where taskId in (select taskId from " +  CtConstants.DB_Ct_UserTaskTable + " where userid='" + userId +"')";
		sql="select * from " +  CtConstants.DB_Ct_TaskTable ;
		return(getInstance().getCustomDataQuery(sql));
	}
	public static CtTaskCollector getInstance()
	{
		return me;
	}

	@Override
	protected CtTasks createObject(ResultSet rs) throws SQLException
	{
		CtTasks bu = new CtTasks();
		bu.setTaskId(rs.getInt("taskId"));
		bu.setTaskName(rs.getString("taskName"));
		bu.setTaskDescription(rs.getString("taskdescription"));

		return bu;
	}
	public static String insertNewTask(int userId,String taskName,String taskDescription)
	{
		System.out.println(taskName);
		System.out.println(taskDescription);
		String sql= "insert into " +  CtConstants.DB_Ct_TaskTable + " (taskName,taskdescription) values ('" +taskName +"'" + " ,'" + taskDescription +"')";
		//sql="insert into ct_tasks(taskName,taskdescription) values ('Something', 'something something')";
		System.out.println(sql);
		int rs = getInstance().InsertRows(sql);
		//System.out.println(rs);
		if (rs!=-1)
         {
			int taskId=rs;
			sql= "insert into " +  CtConstants.DB_Ct_UserTaskTable + "(userId,taskId) values ('" + userId +"'," + " '" + taskId +"')";
			System.out.println(sql);
			rs = getInstance().InsertRows(sql);
			if(rs!=-1)
			{
				//System.out.println(rs);
				return "SUCCESS";
			}
			else
				return "FAILURE";
         }
		else
			return "FAILURE";
	}
	/*public static void main(String a)
	{
		System.out.println(CtTaskCollector.insertNewTask("drawing", "kids art project"));
	    System.out.print("Hello");
	}*/

}