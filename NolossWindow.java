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

public class NolossWindow extends JFrame
{
	public NolossWindow(String telephone)
	{
		JLabel nameJl = new JLabel("  姓    名：");
		JLabel phoneJl = new JLabel("手机号码：");
		JLabel cardJl = new JLabel("    身份证：");
		JLabel idJl = new JLabel("银行账号：");
		
		JTextField nameJt = new JTextField(20);
		JTextField phoneJt = new JTextField(20);
		JTextField cardJt = new JTextField(20);
		JTextField idJt = new JTextField(20);
		
		JButton lossJb = new JButton("取挂");
		JButton returnJb = new JButton("返回");

		Container cp=getContentPane();
		cp.setLayout(new GridLayout(6, 1, 10, 10));
		
		JPanel p1 = new JPanel(new FlowLayout(1,0,0));
		JPanel p2 = new JPanel(new FlowLayout(1,0,0));
		JPanel p3 = new JPanel(new FlowLayout(1,0,0));
		JPanel p4 = new JPanel(new FlowLayout(1,0,0));
		JPanel p5 = new JPanel(new FlowLayout(1,100,0));
		JPanel p6 = new JPanel(new FlowLayout(1,0,0));
		
		p1.add(nameJl);
		p1.add(nameJt);
		
		p2.add(phoneJl);
		p2.add(phoneJt);
		
		p3.add(cardJl);
		p3.add(cardJt);
		
		p4.add(idJl);
		p4.add(idJt);
		
		p5.add(lossJb);
		p5.add(returnJb);
		
		cp.add(p1);
		cp.add(p2);
		cp.add(p3);
		cp.add(p4);
		cp.add(p5);
		cp.add(p6);
		
		
		phoneJt.setDocument(new DataVerify().newNumberTextField());
		cardJt.setDocument(new DataVerify().newNumberTextField());
		idJt.setDocument(new DataVerify().newNumberTextField());
		
		
		returnJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				new Window(telephone);
				dispose();
			}
		});
		
		lossJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String name = nameJt.getText();
				String card = cardJt.getText();
				String id = idJt.getText();
				String phone = phoneJt.getText();
			
				if(telephone.equals(phone))
				{
					//是自己的
					EnSure sure = new EnSure();
					String l = sure.noloss(name, telephone, card, id);
					JOptionPane.showMessageDialog(null, l);
				}else {
					JOptionPane.showMessageDialog(null, "手机号码非本账户");
				}
			}
		});
		
		setBounds(850,430,380,450);		
		setVisible(true);
		setTitle("村镇银行取挂系统");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args)
	{
		new NolossWindow("12345678901");
	}
}
