package mySQL;

import java.sql.*;

//��ɾ��

public class Renewal
{
	
	//static ���������Ȼ����
	static Connection con;
	static PreparedStatement sql;
	static ResultSet res;

	BasicInformation bas = new BasicInformation();

	public Renewal()
	{
		// �����������ݿ������
		Conn c = new Conn();

		// �����ݿ⽨������
		con = c.getConnection();
	}
	
	//��
	public boolean add(String name) throws Exception 
	{
		sql = con.prepareStatement("insert into user(name,telephone) values(?,?)");
		sql.setString(1, name);
		sql.setString(2, "65412398700");
		sql.executeUpdate();
		return true;
	}
	
	//ɾ
	public boolean delete(String name) throws Exception
	{
		sql = con.prepareStatement("delete from user where name = ?	");
		sql.setString(1, name);
		sql.executeUpdate();
		return true;
	}
	
	// ��
	public boolean change(String beforeName, String afterName) throws Exception
	{
		sql = con.prepareStatement("update user set name = ?" + " where name = '" + beforeName + "'");
		sql.setString(1, afterName);
		sql.executeUpdate();
		return true;
	}

}
