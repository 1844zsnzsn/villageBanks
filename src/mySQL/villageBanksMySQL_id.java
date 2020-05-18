package mySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class villageBanksMySQL_id
{
	private String telephone = null;

	private int id = -1;

	// �Ƿ�ӵ���˻�
	private boolean account = false;

	static Connection con;
	static PreparedStatement sqll;
	static ResultSet res;
	static Statement sql;

	BasicInformation bas = new BasicInformation();

	public villageBanksMySQL_id()
	{
		// TODO Auto-generated constructor stub
		// ѡ��
		String form = "id";
		bas.setForm(form);

		// �����������ݿ������
		Conn c = new Conn();

		// �����ݿ⽨������
		con = c.getConnection();
	}

	// ͨ������Ԥ���ֻ������ж��û��Ƿ�ӵ�������˺�
	public boolean havaID(String telephone)
	{
		try
		{
			sql = con.createStatement();
			res = sql.executeQuery("select * from " + bas.getForm());
			while (res.next())
			{
				if (res.getString("telephone").equals(telephone))
				{
					this.telephone = telephone;
					System.out.println(res.getString("account"));
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

	// ��Ҫ��havaID //�ж��Ƿ�ע���
	public boolean isAccount()
	{
		try
		{
			sql = con.createStatement();
			res = sql.executeQuery("select * from " + bas.getForm());
			while (res.next())
			{
				if (res.getString("telephone").equals(this.telephone) && res.getString("account").equals("1"))
				{
					// ӵ��app�˻�
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

	// ��ȡ��� ǰ��������ȡhavaID
	public float getVacancy_telephone(String phone)
	{
		try
		{
			sql = con.createStatement();
			res = sql.executeQuery("select * from " + bas.getForm());
			while (res.next())
			{
				if (res.getString("telephone").equals(phone))
				{
					// ӵ��app�˻�
					return res.getFloat("vacancy");
				}
			}
			return 0;

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	// δӵ��app�˻�--��ӵ��
	public void changeAccount(String telephone) throws SQLException
	{
		sqll = con.prepareStatement(
				"update " + bas.getForm() + " set account = ?" + " where telephone = '" + telephone + "'");
		sqll.setString(1, "1");
		sqll.executeUpdate();
	}

	// �Ƿ�����˻�
	public String haveId(String id)
	{
		try
		{
			sql = con.createStatement();
			res = sql.executeQuery("select * from " + bas.getForm());
			while (res.next())
			{
				if (res.getString("id").equals(id))
				{
					return res.getString("telephone");
				}
			}
			return "���޴˺�";

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return "���޴˺�";
	}

	// �ı��Լ����
	public void transfer(String telephone, float money) throws SQLException
	{
		sqll = con.prepareStatement(
				"update " + bas.getForm() + " set vacancy = ?" + " where telephone = '" + telephone + "'");
		String va = Float.toString(getVacancy_telephone(telephone) - money);

		sqll.setString(1, va);
		sqll.executeUpdate();
	}

	// �ı���˽��
	public void transfer2(String id, float money) throws SQLException
	{
		String p = haveId(id);
		sqll = con.prepareStatement("update " + bas.getForm() + " set vacancy = ?" + " where id = '" + id + "'");
		String va = Float.toString(getVacancy_telephone(p) + money);
		sqll.setString(1, va);
		sqll.executeUpdate();
	}

	public boolean isPass(String telephone, String pass)
	{
		try
		{
			sql = con.createStatement();
			res = sql.executeQuery("select * from " + bas.getForm());
			while (res.next())
			{
				if (res.getString("pass").equals(pass))
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
	
	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}
}
