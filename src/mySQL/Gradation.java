package mySQL;

import java.sql.*;

//˳���ѯ    ģ����ѯ
public class Gradation
{
	static Connection con;
	static Statement sql;
	static ResultSet res;
	
	BasicInformation bas = new BasicInformation();
	
	public Gradation()
	{

		// �����������ݿ������
		Conn c = new Conn();
		
		// �����ݿ⽨������
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
				System.out.println("������" + name);
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
