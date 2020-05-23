package villageBanks;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ChangePasswordWindow extends JFrame
{
	public ChangePasswordWindow(String telephone)
	{
		JLabel passwordJl = new JLabel("    原  密  码：");
		JLabel newPasswordJl = new JLabel("    新  密  码：");
		JLabel newPasswordJl2 = new JLabel("重复新密码：");

		JTextField passwordJt = new JTextField(20);

		JPasswordField newPasswordJt = new JPasswordField(20);
		JPasswordField newPasswordJt2 = new JPasswordField(20);

		JButton changeJb = new JButton("修改");
		JButton returnJb = new JButton("返回");

		newPasswordJt.setEchoChar('*');
		newPasswordJt2.setEchoChar('*');

		Container cp = getContentPane();
		cp.setLayout(new GridLayout(5, 1, 10, 10));

		JPanel p1 = new JPanel(new FlowLayout(1, 20, 0));
		JPanel p2 = new JPanel(new FlowLayout(1, 20, 0));
		JPanel p3 = new JPanel(new FlowLayout(1, 20, 0));
		JPanel p4 = new JPanel(new FlowLayout(1, 120, 0));
		JPanel p5 = new JPanel(new FlowLayout(1, 20, 0));

		p1.add(passwordJl);
		p1.add(passwordJt);

		p2.add(newPasswordJl);
		p2.add(newPasswordJt);

		p3.add(newPasswordJl2);
		p3.add(newPasswordJt2);

		p4.add(changeJb);
		p4.add(returnJb);

		cp.add(p5);
		cp.add(p1);
		cp.add(p2);
		cp.add(p3);
		cp.add(p4);
		
		newPasswordJt.addFocusListener(new FocusListener()
		{

			@Override
			public void focusGained(FocusEvent e)
			{
				// TODO Auto-generated method stub
				// 组件获取焦点时调用的方法
				newPasswordJt.setText("");
			}

			@Override
			public void focusLost(FocusEvent e)
			{
			}
		});
		
		newPasswordJt2.addFocusListener(new FocusListener()
		{

			@Override
			public void focusGained(FocusEvent e)
			{
				// TODO Auto-generated method stub
				// 组件获取焦点时调用的方法
				newPasswordJt2.setText("");
			}

			@Override
			public void focusLost(FocusEvent e)
			{
			}
		});
		
		returnJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				new Window(telephone);
				dispose();
			}
		});

		changeJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				String password = passwordJt.getText();
				String newpassword = newPasswordJt.getText();
				String newpassword2 = newPasswordJt2.getText();
				// 输入旧密码 新密码 重复密码 完成修改
				EnSure sure = new EnSure();
				String cPassword = sure.changePassword(telephone, password, newpassword, newpassword2);
				
				JOptionPane.showMessageDialog(null, cPassword);
			}
		});

		setBounds(850, 430, 380, 450);
		setVisible(true);
		setTitle("村镇银行修改密码系统");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args)
	{
		new ChangePasswordWindow("12345678901");
	}
}
