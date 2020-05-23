package villageBanks;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class RechargeWindow extends JFrame
{
	public RechargeWindow(String telephone)
	{
		JLabel phoneJl = new JLabel("手机号码：");
		JLabel passJl = new JLabel("支付密码：");
		JLabel moneyJl = new JLabel("充值金额：");
		
		JTextField phoneJt = new JTextField(20);
		JTextField passJt = new JTextField(20);
		JTextField moneyJt = new JTextField(20);
		
		
		JButton rechargeJb = new JButton("充值");
		JButton returnJb = new JButton("返回");
	
		Container cp=getContentPane();
		cp.setLayout(new GridLayout(5, 1, 10, 10));
		
		JPanel p1 = new JPanel(new FlowLayout(1,0,0));
		JPanel p2 = new JPanel(new FlowLayout(1,0,0));
		JPanel p3 = new JPanel(new FlowLayout(1,100,0));
		JPanel p4 = new JPanel(new FlowLayout(1,0,0));
		JPanel p5 = new JPanel(new FlowLayout(1,0,0));
		
		p1.add(phoneJl);
		p1.add(phoneJt);
		
		p2.add(passJl);
		p2.add(passJt);
		
		p3.add(rechargeJb);
		p3.add(returnJb);
		
		p4.add(moneyJl);
		p4.add(moneyJt);
		
		cp.add(p1);
		cp.add(p2);
		cp.add(p4);
		cp.add(p3);
	
		returnJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				new LoginWindow();
				dispose();
			}
		});
		
		rechargeJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String phone = phoneJt.getText();
				String money = moneyJt.getText();
				String pass = passJt.getText();
				EnSure sure = new EnSure();
				String r = sure.recharge(telephone, money, phone, pass);
				JOptionPane.showMessageDialog(null, r);
			}
		});
		
		phoneJt.setDocument(new DataVerify().newNumberTextField());
		passJt.setDocument(new DataVerify().newNumberTextField());
		moneyJt.setDocument(new DataVerify().newNumberTextField());
		
		
		setBounds(850,430,380,450);		
		setVisible(true);
		setTitle("村镇银行花费充值系统");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args)
	{
		new RechargeWindow("12345678901");
	}
}
