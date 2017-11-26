package com.collabTool.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.collabTool.database.object.CtTasks;
import com.collabTool.database.object.CtUsers;
import com.collabTool.main.CtConstants;

public class CtTaskCollector extends BaseDao
{
public static CtTaskCollector me=new CtTaskCollector();
public static List<CtTasks> getMyTasks(int userId)
{
	String sql= "select * from " +  CtConstants.DB_Ct_TaskTable + " where taskId in (select taskId from " +  CtConstants.DB_Ct_UserTaskTable + " where userid='" + userId +"')";
	return(getInstance().getCustomData(sql));
}
public static CtTaskCollector getInstance()
{
	return me;
}

	@Override
	protected CtTasks createObject(ResultSet rs) throws SQLException {
		CtTasks bu = new CtTasks();
        bu.setTaskId(rs.getInt("taskId"));
        bu.setTaskName(rs.getString("taskName"));
        bu.setTaskDescription(rs.getString("taskdescription"));
       
        return bu;
	}

}
