package villageBanks;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class TransferWindow extends JFrame
{
	DataVerify v = new DataVerify();

	public TransferWindow(String telephone)
	{
		JLabel cardJl = new JLabel("对方账号：");
		JLabel nameJl = new JLabel("对方姓名：");
		JLabel moneyJl = new JLabel("转账金额：");

		JTextField cardJt = new JTextField(20);
		JTextField nameJt = new JTextField(20);
		JTextField moneyJt = new JTextField(20);

		JButton sureJb = new JButton("确定");
		JButton returnJb = new JButton("返回");

		Container cp = getContentPane();
		cp.setLayout(new GridLayout(5, 1, 10, 10));

		JPanel p1 = new JPanel(new FlowLayout(1, 20, 0));
		JPanel p2 = new JPanel(new FlowLayout(1, 20, 0));
		JPanel p3 = new JPanel(new FlowLayout(1, 20, 0));
		JPanel p4 = new JPanel(new FlowLayout(1, 120, 0));
		JPanel p5 = new JPanel(new FlowLayout(1, 20, 0));

		p1.add(cardJl);
		p1.add(cardJt);

		p2.add(nameJl);
		p2.add(nameJt);

		p3.add(moneyJl);
		p3.add(moneyJt);

		p4.add(sureJb);
		p4.add(returnJb);

		cp.add(p5);
		cp.add(p1);
		cp.add(p2);
		cp.add(p3);
		cp.add(p4);

		returnJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				new Window(telephone);
				dispose(); // 关闭当前窗口
			}
		});

		sureJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String card = cardJt.getText();
				String name = nameJt.getText();
				String money = moneyJt.getText();
				EnSure sure = new EnSure();
				String t = sure.transfer(telephone, card, name, money);
				JOptionPane.showMessageDialog(null, t);
			}
		});

		
		nameJt.addFocusListener(new FocusListener()
		{

			@Override
			public void focusGained(FocusEvent e)
			{
				// TODO Auto-generated method stub
			
			}

			@Override
			public void focusLost(FocusEvent e)
			{
				// TODO Auto-generated method stub
				String card = cardJt.getText();
				if (!v.idVerify(card) || v.emptyText(card))
				{
					JOptionPane.showMessageDialog(null, "账号有误");
				}
			}
		});
		cardJt.setDocument(new DataVerify().newNumberTextField());
		moneyJt.setDocument(new DataVerify().newNumberTextField());
		
		
		setBounds(850, 430, 380, 450);
		setVisible(true);
		setTitle("村镇银行转账系统");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args)
	{
		new TransferWindow("12345678901");
	}
}
