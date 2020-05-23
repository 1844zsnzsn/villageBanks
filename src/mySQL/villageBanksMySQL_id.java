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

	// 是否拥有账户
	private boolean account = false;

	static Connection con;
	static PreparedStatement sqll;
	static ResultSet res;
	static Statement sql;

	BasicInformation bas = new BasicInformation();

	public villageBanksMySQL_id()
	{
		// TODO Auto-generated constructor stub
		// 选表
		String form = "id";
		bas.setForm(form);

		// 创建连接数据库类对象
		Conn c = new Conn();

		// 与数据库建立连接
		con = c.getConnection();
	}

	// 通过银行预留手机号码判断用户是否拥有银行账号
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

	// 需要先havaID //判断是否注册过
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
					// 拥有app账户
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

	// 获取金额 前置条件获取havaID
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
					// 拥有app账户
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

	// 未拥有app账户--》拥有
	public void changeAccount(String telephone) throws SQLException
	{
		sqll = con.prepareStatement(
				"update " + bas.getForm() + " set account = ?" + " where telephone = '" + telephone + "'");
		sqll.setString(1, "1");
		sqll.executeUpdate();
	}

	// 是否存在账户
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
			return "查无此号";

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return "查无此号";
	}

	// 改变自己金额
	public void transfer(String telephone, float money) throws SQLException
	{
		sqll = con.prepareStatement(
				"update " + bas.getForm() + " set vacancy = ?" + " where telephone = '" + telephone + "'");
		String va = Float.toString(getVacancy_telephone(telephone) - money);

		sqll.setString(1, va);
		sqll.executeUpdate();
	}

	// 改变别人金额
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
