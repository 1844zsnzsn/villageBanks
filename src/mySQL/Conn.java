package mySQL;

import java.sql.*;

//连接数据库

public class Conn
{
	Connection con;
	BasicInformation bas = new BasicInformation();
	
	public Conn()
	{
		// TODO Auto-generated constructor stub
	}
	
	public Connection getConnection()
	{
		try
		{

			Class.forName("com.mysql.jdbc.Driver");

//			System.out.println("数据库驱动加载成功");
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
		try
		{
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/villagebanks", "root", "root");

			con = DriverManager.getConnection(bas.getUrl() + bas.getSQL(), bas.getUserName(), bas.getPassword());

//			System.out.println("数据库连接成功");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
}