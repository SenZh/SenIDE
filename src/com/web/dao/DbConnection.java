package com.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DbConnection dbc=new DbConnection("sen", "123456", "127.0.0.1", "shopping", "3306");
		Statement stm=dbc.getStatement();
		ResultSet rs=stm.executeQuery("select * from items");
		while(rs.next())
		{
			System.out.println(rs.getString("name"));
		}
		

	}
	
	private String user,password,host,database,port;
	public DbConnection(String user,String password,String host,String database,String port)
	{
		this.user=user;
		this.password=password;
		this.host=host;
		this.database=database;
		this.port=port;
	}
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+database, user, password);
	}
	public Statement getStatement() throws ClassNotFoundException, SQLException
	{
		Connection conn;
		if((conn=getConnection())!=null)
		{
			return conn.createStatement();
		}
		else {
			return null;
		}
		
	}

}
