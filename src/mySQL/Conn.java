package mySQL;

import java.sql.*;

//�������ݿ�

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

//			System.out.println("���ݿ��������سɹ�");
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
		try
		{
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/villagebanks", "root", "root");

			con = DriverManager.getConnection(bas.getUrl() + bas.getSQL(), bas.getUserName(), bas.getPassword());

//			System.out.println("���ݿ����ӳɹ�");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
}