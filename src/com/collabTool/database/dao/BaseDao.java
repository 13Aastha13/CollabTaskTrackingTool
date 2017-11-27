package com.collabTool.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.collabTool.database.DatabaseConnector;



public abstract class BaseDao<T>
{
	public ArrayList<T> getCustomDataQuery(String sql)
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

	public int InsertRows(String sql)
	{
		//ArrayList<T> list = new ArrayList<T>();
		PreparedStatement stmt = null;
		ResultSet rs = null;     

		try {
			stmt = DatabaseConnector.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();//executeQuery();
			rs = stmt.getGeneratedKeys();
			rs.next();
			 //System.out.println(rs.getInt(1));
			return rs.getInt(1);
		} catch (SQLException e)
		{

			e.printStackTrace();
		} finally 
		{
			try { if (rs != null) rs.close(); } catch (Exception e) {};
			try { if (stmt != null) stmt.close(); } catch (Exception e) {};
		}

		return -1;

	}

	protected abstract T createObject (ResultSet rs) throws SQLException;

}
