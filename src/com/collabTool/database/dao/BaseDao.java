package com.collabTool.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.collabTool.database.DatabaseConnector;
import com.collabTool.database.object.CtUsers;



public abstract class BaseDao<T>
{
	public ArrayList<T> getCustomData(String sql)
	{
		ArrayList<T> list = new ArrayList<T>();
		PreparedStatement stmt = null;
        ResultSet rs = null;     

        try {
            stmt = DatabaseConnector.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) 
            {
                list.add(createObject(rs));
            }
        } catch (SQLException e)
        {
            
            e.printStackTrace();
        } finally 
        {
            try { if (rs != null) rs.close(); } catch (Exception e) {};
            try { if (stmt != null) stmt.close(); } catch (Exception e) {};
        }
        
        return list;
		
	}

	 protected abstract T createObject (ResultSet rs) throws SQLException;

}
