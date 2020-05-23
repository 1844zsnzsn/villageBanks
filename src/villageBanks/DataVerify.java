package villageBanks;

import javax.swing.text.AttributeSet;
import javax.swing.text.PlainDocument;

public class DataVerify
{
	public DataVerify()
	{
		// TODO Auto-generated constructor stub
	}

	// 信息不可为空
	public boolean emptyText(String text)
	{
		if (text.length() == 0)
		{
			return true;
		} else
		{
			return false;
		}
	}

	// 密码位数限制
	public boolean amountPassword(String password)
	{
		if (password.length() >= 6 && password.length() <= 20)
		{
			return true;
		} else
		{
			return false;
		}
	}

	// 两次密码是否相同判断 密码要求6-20位
	public boolean samePassword(String password, String password2)
	{
		if (password.equalsIgnoreCase(password2))
		{
			return true;
		} else
		{
			return false;
		}
	}

	// 手机号码格式判断
	public boolean phoneVerify(String text)
	{
		int size = text.length();
		if (size == 11)
		{
			return true;
		} else
		{
			return false;
		}

	}

	// 身份证号码格式判断
	public boolean cardVerify(String text)
	{
		int size = text.length();
		if (size == 18)
		{
			return true;
		} else
		{
			return false;
		}

	}

	// 返回事件文本域过滤非数字类
	public NumberTextField newNumberTextField()
	{
		return new NumberTextField();
	}

	// 判断是否为纯汉字
	public boolean isutf_8(String name)
	{
		char nameArray[] = name.toCharArray();
		
		for (int i = 0; i < nameArray.length; i++)
		{
			if (nameArray[i] <= 0x4E00 || nameArray[i] >= 0x29FA5)
			{
				return false;
			}
		}
		return true;
	}

	public boolean idVerify(String text)
	{
		int size = text.length();
		if (size == 19)
		{
			return true;
		} else
		{
			return false;
		}
	}
	
	// 文本域过滤非数字
	class NumberTextField extends PlainDocument
	{
		public NumberTextField()
		{
			super();
		}

		public void insertString(int offset, String str, AttributeSet attr) throws javax.swing.text.BadLocationException
		{
			if (str == null)
			{
				return;
			}

			char[] s = str.toCharArray();
			int length = 0;
			// 过滤非数字
			for (int i = 0; i < s.length; i++)
			{
				if ((s[i] >= '0') && (s[i] <= '9'))
				{
					s[length++] = s[i];
				}
				// 插入内容
				super.insertString(offset, new String(s, 0, length), attr);
			}
		}
	}
}
