package mySQL;

import java.sql.*;

//增删改

public class Renewal
{
	
	//static 不是这个竟然报错
	static Connection con;
	static PreparedStatement sql;
	static ResultSet res;

	BasicInformation bas = new BasicInformation();

	public Renewal()
	{
		// 创建连接数据库类对象
		Conn c = new Conn();

		// 与数据库建立连接
		con = c.getConnection();
	}
	
	//增
	public boolean add(String name) throws Exception 
	{
		sql = con.prepareStatement("insert into user(name,telephone) values(?,?)");
		sql.setString(1, name);
		sql.setString(2, "65412398700");
		sql.executeUpdate();
		return true;
	}
	
	//删
	public boolean delete(String name) throws Exception
	{
		sql = con.prepareStatement("delete from user where name = ?	");
		sql.setString(1, name);
		sql.executeUpdate();
		return true;
	}
	
	// 改
	public boolean change(String beforeName, String afterName) throws Exception
	{
		sql = con.prepareStatement("update user set name = ?" + " where name = '" + beforeName + "'");
		sql.setString(1, afterName);
		sql.executeUpdate();
		return true;
	}

}
