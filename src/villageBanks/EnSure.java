package villageBanks;

import java.sql.SQLException;

import org.junit.jupiter.engine.discovery.predicates.IsPotentialTestContainer;

import mySQL.VillageBanksMySQL_uer;
import mySQL.villageBanksMySQL_id;

public class EnSure
{
	DataVerify v = new DataVerify();

	villageBanksMySQL_id vid = new villageBanksMySQL_id();

	VillageBanksMySQL_uer vu = new VillageBanksMySQL_uer();

	public EnSure()
	{
		// TODO Auto-generated constructor stub
	}

	public String register(String name, String phone, boolean gender, String password, String password2, String card)
			throws Exception
	{
		// 输入验证
		if (v.emptyText(name))
		{
			return "请输入姓名";
		}

		if (v.emptyText(phone))
		{
			return "请输入手机号码";
		}

		if (v.emptyText(password))
		{
			return "请输入密码";
		}

		if (v.emptyText(password2))
		{
			return "请再次输入密码";
		}

		if (!v.isutf_8(name))
		{
			return "名字中存在非法字符";
		}

		if (!v.phoneVerify(phone))
		{
			return "手机号码格式有误";
		}

		if (!v.amountPassword(password))
		{
			return "密码应为6-20位字符";
		}

		if (!v.samePassword(password, password2))
		{
			return "两次输入密码不相同";
		}

		if (!v.cardVerify(card))
		{
			return "身份证号码有误";
		}
		// 判断是否拥有银行账户 根据银行预留手机号码
		if (vid.havaID(phone))
		{
			// 有账户
			if (vid.isAccount())
			{
				return "你已经拥有app账号";
				// 有app账户
			} else
			{
				// 没有app账户 将信息输入数据库
				vu.addRegister(name, phone, password, card, gender);
				vid.changeAccount(phone);
				return "信息录入成功";
			}
		} else
		{
			return "您在本行并未办理银行账户";
		}
		// 信息提交
	}

	public String login(String telephone, String password)
	{
		// 手机号码未注册
		// 手机号码有误？ 空？
		// 密码错误
		if (!vu.haveTelephone(telephone))
		{
			return "手机号码未注册";
		}

		if (v.emptyText(telephone))
		{
			return "请输入手机号码";
		}

		if (v.emptyText(password))
		{
			return "请输入密码";
		}

		if (!v.amountPassword(password))
		{
			return "密码有误";
		}

		if (vu.login_matching(telephone, password))
		{
			return "登陆成功";
		} else
		{
			return "密码错误";
		}
	}

	public String changePassword(String telephone, String password, String newpassword, String newpassword2)
	{
		if (v.emptyText(password))
		{
			return "原密码错误";
		}

		if (v.emptyText(newpassword))
		{
			return "新密码错误";
		}

		if (v.emptyText(newpassword2))
		{
			return "请再次输入密码";
		}

		if (!v.amountPassword(newpassword))
		{
			return "密码应为6-20位字符";
		}

		if (!v.samePassword(newpassword, newpassword2))
		{
			return "新密码输入不一致";
		} else
		{
			// 验证原密码是否正确
			if (vu.truePassword(telephone, password))
			{
				// 修改密码
				try
				{
					vu.changePassword(telephone, newpassword);
				} catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "修改成功";
			} else
			{
				return "原密码错误";
			}
		}
	}

	public String transfer(String telephone, String id, String name, String money)
	{
		// 数据验证
		float moneyf = Float.parseFloat(money);

		if (v.emptyText(name))
		{
			return "请输入对方姓名";
		}

		if (v.emptyText(id))
		{
			return "请输入对方账号";
		}

		if (v.emptyText(money))
		{
			return "金额有误";
		}

		if (!v.isutf_8(name))
		{
			return "名字中存在非法字符";
		}

		if (moneyf <= 0)
		{
			return "金额有误";
		}

		// 账号姓名是否符合 金额是否足够
		if (vu.haveName(vid.haveId(id), name))
		{
			// 金额够不
			float vacany = vid.getVacancy_telephone(telephone);
			if (vacany >= moneyf)
			{

				try
				{
					vid.transfer(telephone, moneyf);
					vid.transfer2(id, moneyf);
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return "转账成功";
			} else
			{
				return "金额不足";
			}
		} else
		{
			// 未注册用户无法转账
			return "转账账号信息有误";
		}
	}

	public String loss(String name, String telephone, String card, String id)
	{
		if (v.emptyText(name))
		{
			return "请输入姓名";
		}

		if (v.emptyText(telephone))
		{
			return "请输入手机号码";
		}

		if (v.emptyText(card))
		{
			return "请输入身份证号码";
		}

		if (v.emptyText(id))
		{
			return "请输入银行卡号码";
		}

		if (!v.isutf_8(name))
		{
			return "名字中存在非法字符";
		}

		if (!v.phoneVerify(telephone))
		{
			return "手机号码格式有误";
		}

		if (!v.cardVerify(card))
		{
			return "身份证号码有误";
		}

		if (!v.idVerify(id))
		{
			return "银行卡号码有误";
		}

		if (vid.haveId(id).equals(telephone) && vu.haveCard(telephone, card) && vu.haveName(telephone, name))
		{
			// 挂失
			try
			{
				vu.changeLoss0(telephone);
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "挂失成功";
		} else
		{
			return "信息有误";
		}
	}

	public String noloss(String name, String telephone, String card, String id)
	{
		if (v.emptyText(name))
		{
			return "请输入姓名";
		}

		if (v.emptyText(telephone))
		{
			return "请输入手机号码";
		}

		if (v.emptyText(card))
		{
			return "请输入身份证号码";
		}

		if (v.emptyText(id))
		{
			return "请输入银行卡号码";
		}

		if (!v.isutf_8(name))
		{
			return "名字中存在非法字符";
		}

		if (!v.phoneVerify(telephone))
		{
			return "手机号码格式有误";
		}

		if (!v.cardVerify(card))
		{
			return "身份证号码有误";
		}

		if (!v.idVerify(id))
		{
			return "银行卡号码有误";
		}

		if (vid.haveId(id).equals(telephone) && vu.haveCard(telephone, card) && vu.haveName(telephone, name))
		{
			// 取挂
			try
			{
				vu.changeLoss1(telephone);
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "取挂成功";
		} else
		{
			return "信息有误";
		}
	}

	public String recharge(String telephone, String money, String phone, String pass)
	{

		float moneyf = Float.parseFloat(money);
		float vacany = vid.getVacancy_telephone(telephone);
		
		if (v.emptyText(phone))
		{
			return "请输入手机号码";
		}

		if (v.emptyText(pass))
		{
			return "请输入支付密码";
		}

		if (v.emptyText(money))
		{
			return "请输入充值金额";
		}
		
		if (!v.phoneVerify(phone))
		{
			return "手机号码格式有误";
		}

		if (moneyf <= 0)
		{
			return "金额有误";
		}
		
		if(vid.isPass(telephone, pass))
		{
			if(moneyf <= vacany)
			{
				try
				{
					vid.transfer(telephone, moneyf);
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "充值成功";
			}else {
				return "余额不足";
			}
		}else {
			return "支付密码错误";
		}
	}
	
	public String ChangeInformation(String telephone , boolean gender, String phone) throws Exception
	{
		if(v.emptyText(phone))
		{
			return "手机号码不可为空";
		}
		
		if(!v.phoneVerify(phone))
		{
			return "手机号码不符合规格";
		}
		
		if(gender) {
			vu.changeGender(telephone, "男");
			vu.changeTelephone(telephone, phone);
			return "修改成功";
		}else {
			vu.changeGender(telephone, "女");
			vu.changeTelephone(telephone, phone);
			return "修改成功";
		}
		
	}
	
}
