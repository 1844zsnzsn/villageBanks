package mySQL;

import java.sql.*;

//顺序查询    模糊查询
public class Gradation
{
	static Connection con;
	static Statement sql;
	static ResultSet res;
	
	BasicInformation bas = new BasicInformation();
	
	public Gradation()
	{

		// 创建连接数据库类对象
		Conn c = new Conn();
		
		// 与数据库建立连接
		con = c.getConnection();

	}

	public void outName()
	{
		try
		{
			sql = con.createStatement();
			res = sql.executeQuery("select * from " + bas.getForm() );
			
			while(res.next())
			{
				String name = res.getString("name");
				System.out.println("姓名：" + name);
			}
			System.out.println();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean findSB(String name)
	{
		try
		{
			sql = con.createStatement();
			res = sql.executeQuery("select * from " + bas.getForm() );
			while(res.next())
			{
				if(res.getString("name").equals(name))
				{
					return true;
				}
			}
			return false;
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
}
