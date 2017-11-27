package com.collabTool.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;





import com.collabTool.database.object.CtUsers;
import com.collabTool.main.CtConstants;

@SuppressWarnings("rawtypes")
public class CtUsersDao extends BaseDao
{ 
	public static CtUsersDao me=new CtUsersDao();
	@SuppressWarnings("unchecked")
	public static List<CtUsers> getUser(String email, String password)
	{
		String sql= "select * from " +  CtConstants.DB_Ct_UserTable + " where email = UPPER('" + email + "')" + " and password ='" + password +"'" ;
		return(getInstance().getCustomDataQuery(sql));
	}
	public static CtUsersDao getInstance()
	{
		return me;
	}
	protected CtUsers createObject(ResultSet rs) throws SQLException {
        CtUsers bu = new CtUsers();
        bu.setUserid(rs.getInt("userid"));
        bu.setUsername(rs.getString("username"));
        bu.setPassword("password");
        bu.setEmail("email");
        
        return bu;
    }

}
