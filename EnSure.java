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
		// ������֤
		if (v.emptyText(name))
		{
			return "����������";
		}

		if (v.emptyText(phone))
		{
			return "�������ֻ�����";
		}

		if (v.emptyText(password))
		{
			return "����������";
		}

		if (v.emptyText(password2))
		{
			return "���ٴ���������";
		}

		if (!v.isutf_8(name))
		{
			return "�����д��ڷǷ��ַ�";
		}

		if (!v.phoneVerify(phone))
		{
			return "�ֻ������ʽ����";
		}

		if (!v.amountPassword(password))
		{
			return "����ӦΪ6-20λ�ַ�";
		}

		if (!v.samePassword(password, password2))
		{
			return "�����������벻��ͬ";
		}

		if (!v.cardVerify(card))
		{
			return "���֤��������";
		}
		// �ж��Ƿ�ӵ�������˻� ��������Ԥ���ֻ�����
		if (vid.havaID(phone))
		{
			// ���˻�
			if (vid.isAccount())
			{
				return "���Ѿ�ӵ��app�˺�";
				// ��app�˻�
			} else
			{
				// û��app�˻� ����Ϣ�������ݿ�
				vu.addRegister(name, phone, password, card, gender);
				vid.changeAccount(phone);
				return "��Ϣ¼��ɹ�";
			}
		} else
		{
			return "���ڱ��в�δ���������˻�";
		}
		// ��Ϣ�ύ
	}

	public String login(String telephone, String password)
	{
		// �ֻ�����δע��
		// �ֻ��������� �գ�
		// �������
		if (!vu.haveTelephone(telephone))
		{
			return "�ֻ�����δע��";
		}

		if (v.emptyText(telephone))
		{
			return "�������ֻ�����";
		}

		if (v.emptyText(password))
		{
			return "����������";
		}

		if (!v.amountPassword(password))
		{
			return "��������";
		}

		if (vu.login_matching(telephone, password))
		{
			return "��½�ɹ�";
		} else
		{
			return "�������";
		}
	}

	public String changePassword(String telephone, String password, String newpassword, String newpassword2)
	{
		if (v.emptyText(password))
		{
			return "ԭ�������";
		}

		if (v.emptyText(newpassword))
		{
			return "���������";
		}

		if (v.emptyText(newpassword2))
		{
			return "���ٴ���������";
		}

		if (!v.amountPassword(newpassword))
		{
			return "����ӦΪ6-20λ�ַ�";
		}

		if (!v.samePassword(newpassword, newpassword2))
		{
			return "���������벻һ��";
		} else
		{
			// ��֤ԭ�����Ƿ���ȷ
			if (vu.truePassword(telephone, password))
			{
				// �޸�����
				try
				{
					vu.changePassword(telephone, newpassword);
				} catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "�޸ĳɹ�";
			} else
			{
				return "ԭ�������";
			}
		}
	}

	public String transfer(String telephone, String id, String name, String money)
	{
		// ������֤
		float moneyf = Float.parseFloat(money);

		if (v.emptyText(name))
		{
			return "������Է�����";
		}

		if (v.emptyText(id))
		{
			return "������Է��˺�";
		}

		if (v.emptyText(money))
		{
			return "�������";
		}

		if (!v.isutf_8(name))
		{
			return "�����д��ڷǷ��ַ�";
		}

		if (moneyf <= 0)
		{
			return "�������";
		}

		// �˺������Ƿ���� ����Ƿ��㹻
		if (vu.haveName(vid.haveId(id), name))
		{
			// ����
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

				return "ת�˳ɹ�";
			} else
			{
				return "����";
			}
		} else
		{
			// δע���û��޷�ת��
			return "ת���˺���Ϣ����";
		}
	}

	public String loss(String name, String telephone, String card, String id)
	{
		if (v.emptyText(name))
		{
			return "����������";
		}

		if (v.emptyText(telephone))
		{
			return "�������ֻ�����";
		}

		if (v.emptyText(card))
		{
			return "���������֤����";
		}

		if (v.emptyText(id))
		{
			return "���������п�����";
		}

		if (!v.isutf_8(name))
		{
			return "�����д��ڷǷ��ַ�";
		}

		if (!v.phoneVerify(telephone))
		{
			return "�ֻ������ʽ����";
		}

		if (!v.cardVerify(card))
		{
			return "���֤��������";
		}

		if (!v.idVerify(id))
		{
			return "���п���������";
		}

		if (vid.haveId(id).equals(telephone) && vu.haveCard(telephone, card) && vu.haveName(telephone, name))
		{
			// ��ʧ
			try
			{
				vu.changeLoss0(telephone);
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "��ʧ�ɹ�";
		} else
		{
			return "��Ϣ����";
		}
	}

	public String noloss(String name, String telephone, String card, String id)
	{
		if (v.emptyText(name))
		{
			return "����������";
		}

		if (v.emptyText(telephone))
		{
			return "�������ֻ�����";
		}

		if (v.emptyText(card))
		{
			return "���������֤����";
		}

		if (v.emptyText(id))
		{
			return "���������п�����";
		}

		if (!v.isutf_8(name))
		{
			return "�����д��ڷǷ��ַ�";
		}

		if (!v.phoneVerify(telephone))
		{
			return "�ֻ������ʽ����";
		}

		if (!v.cardVerify(card))
		{
			return "���֤��������";
		}

		if (!v.idVerify(id))
		{
			return "���п���������";
		}

		if (vid.haveId(id).equals(telephone) && vu.haveCard(telephone, card) && vu.haveName(telephone, name))
		{
			// ȡ��
			try
			{
				vu.changeLoss1(telephone);
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "ȡ�ҳɹ�";
		} else
		{
			return "��Ϣ����";
		}
	}

	public String recharge(String telephone, String money, String phone, String pass)
	{

		float moneyf = Float.parseFloat(money);
		float vacany = vid.getVacancy_telephone(telephone);
		
		if (v.emptyText(phone))
		{
			return "�������ֻ�����";
		}

		if (v.emptyText(pass))
		{
			return "������֧������";
		}

		if (v.emptyText(money))
		{
			return "�������ֵ���";
		}
		
		if (!v.phoneVerify(phone))
		{
			return "�ֻ������ʽ����";
		}

		if (moneyf <= 0)
		{
			return "�������";
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
				return "��ֵ�ɹ�";
			}else {
				return "����";
			}
		}else {
			return "֧���������";
		}
	}
	
	public String ChangeInformation(String telephone , boolean gender, String phone) throws Exception
	{
		if(v.emptyText(phone))
		{
			return "�ֻ����벻��Ϊ��";
		}
		
		if(!v.phoneVerify(phone))
		{
			return "�ֻ����벻���Ϲ��";
		}
		
		if(gender) {
			vu.changeGender(telephone, "��");
			vu.changeTelephone(telephone, phone);
			return "�޸ĳɹ�";
		}else {
			vu.changeGender(telephone, "Ů");
			vu.changeTelephone(telephone, phone);
			return "�޸ĳɹ�";
		}
		
	}
	
}
