package mySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class VillageBanksMySQL_uer
{
//	private String name = null; // 姓名
//	private String gender = null; // 性别
//	private String passWord = null; // 密码
//
//	private String telephone = null; // 手机号码
//	private String card = null; // 银行卡号码
//	private String pass = null; // 支付密码
//
//	private float vacancy = -1; // 金额
//
//	private boolean loss = false;

	static Connection con;
	static PreparedStatement sql;
	static ResultSet res;
	static Statement sqll;

	BasicInformation bas = new BasicInformation();

	villageBanksMySQL_id vid = new villageBanksMySQL_id();

	public VillageBanksMySQL_uer()
	{
		// 选表
//		String form = "user";
//		bas.setForm(form);

		// 创建连接数据库类对象
		Conn c = new Conn();

		// 与数据库建立连接
		con = c.getConnection();
	}

	// 将注册信息提交数据库
	public void addRegister(String name, String phone, String password, String card, boolean gender) throws Exception
	{
		sql = con.prepareStatement(
				"insert into " + bas.getForm() + "(name,telephone" + ",password,gender,card,loss) values(?,?,?,?,?,?)");
		sql.setString(1, name);
		sql.setString(2, phone);
		sql.setString(3, password);
		sql.setString(5, card);
		sql.setString(6, "1");
		if (gender)
		{
			sql.setString(4, "男");
		} else
		{
			sql.setString(4, "女");
		}
		sql.executeUpdate();

	}

	// 登陆验证
	public boolean login_matching(String telephone, String password)
	{
		try
		{
			sqll = con.createStatement();
			res = sqll.executeQuery("select * from " + bas.getForm());
			while (res.next())
			{
				if (res.getString("telephone").equals(telephone) && res.getString("password").equals(password))
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

	// 是否拥有app账户
	public boolean haveTelephone(String telephone)
	{
		try
		{
			sqll = con.createStatement();
			res = sqll.executeQuery("select * from " + bas.getForm());
			while (res.next())
			{
				if (res.getString("telephone").equals(telephone))
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

	//验证原密码是否正确
	public boolean truePassword(String telephone, String password)
	{
		try
		{
			sqll = con.createStatement();
			res = sqll.executeQuery("select * from " + bas.getForm());
			while (res.next())
			{
				if (res.getString("telephone").equals(telephone))
				{
					if (res.getString("password").equals(password))
					{
						return true;
					} else
					{
						return false;
					}
				}
			}
			return false;

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean haveName(String telephone, String name)
	{
		try
		{
			sqll = con.createStatement();
			res = sqll.executeQuery("select * from " + bas.getForm());
			while (res.next())
			{
				if (res.getString("telephone").equals(telephone))
				{
					if (res.getString("name").equals(name))
					{
						return true;
					}
					return false;
				}
			}
			return false;

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean haveCard(String telephone, String card)
	{
		try
		{
			sqll = con.createStatement();
			res = sqll.executeQuery("select * from " + bas.getForm());
			while (res.next())
			{
				if (res.getString("telephone").equals(telephone))
				{
					if (res.getString("card").equals(card))
					{
						return true;
					}
					return false;
				}
			}
			return false;

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isBoy(String telephone)
	{
		try
		{
			sqll = con.createStatement();
			res = sqll.executeQuery("select * from " + bas.getForm());
			while (res.next())
			{
				if (res.getString("telephone").equals(telephone))
				{
					if (res.getString("gender").equals("男"))
					{
						return true;
					}
					return false;
				}
			}
			return false;

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean changeTelephone(String telephone, String afterTelephone) throws Exception
	{
		sql = con.prepareStatement("update "+bas.getForm()+" set telephone = ?" + " where telephone = '" + telephone + "'");
		sql.setString(1, afterTelephone);
		sql.executeUpdate();
		return true;
	}
	

	public boolean changeGender(String telephone, String afterGender) throws Exception
	{
		sql = con.prepareStatement("update "+bas.getForm()+" set gender = ?" + " where telephone = '" + telephone + "'");
		sql.setString(1, afterGender);
		sql.executeUpdate();
		return true;
	}
	
	public boolean changePassword(String telephone, String afterPassword) throws Exception
	{
		sql = con.prepareStatement("update "+bas.getForm()+" set password = ?" + " where telephone = '" + telephone + "'");
		sql.setString(1, afterPassword);
		sql.executeUpdate();
		return true;
	}
	
	public boolean changeLoss0(String telephone) throws Exception
	{
		sql = con.prepareStatement("update "+bas.getForm()+" set loss = ?" + " where telephone = '" + telephone + "'");
		sql.setString(1, "0");
		sql.executeUpdate();
		return true;
	}
	
	public boolean changeLoss1(String telephone) throws Exception
	{
		sql = con.prepareStatement("update "+bas.getForm()+" set loss = ?" + " where telephone = '" + telephone + "'");
		sql.setString(1, "1");
		sql.executeUpdate();
		return true;
	}
}
