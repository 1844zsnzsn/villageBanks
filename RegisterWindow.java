package villageBanks;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.PlainDocument;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;

public class RegisterWindow extends JFrame
{
	// ��Ϣ��֤��
	DataVerify v = new DataVerify();

	private String passWordVerify = null;
//	private String passwordVerify = null;
//	private String name = null;
//	private String card = null;
//	private boolean gender = true;

	public RegisterWindow()
	{
		JLabel nameJl = new JLabel("  ��    ����");
		JLabel phoneJl = new JLabel("�ֻ����룺");
		JLabel cardJl = new JLabel("    ���֤��");
		JLabel passwordJl = new JLabel("  ��      �룺");
		JLabel passwordJl2 = new JLabel("�ظ����룺");
		JLabel girlJl = new JLabel("Ů");
		JLabel boyJl = new JLabel("��");

		JTextField nameJt = new JTextField(20);
		JTextField phoneJt = new JTextField(20);
		JTextField cardJt = new JTextField(20);

		JPasswordField passwordJt = new JPasswordField(20);
		JPasswordField passwordJt2 = new JPasswordField(20);

		JRadioButton boyJr = new JRadioButton();
		JRadioButton girlJr = new JRadioButton();

		ButtonGroup group = new ButtonGroup();

		JButton registerJb = new JButton("ע��");
		JButton returnJb = new JButton("����");

		group.add(boyJr);
		group.add(girlJr);

		boyJr.setSelected(true);

		passwordJt.setEchoChar('*');
		passwordJt2.setEchoChar('*');

		Container cp = getContentPane();
		cp.setLayout(new GridLayout(7, 1, 10, 10));

		JPanel p1 = new JPanel(new FlowLayout(1, 0, 0));
		JPanel p2 = new JPanel(new FlowLayout(1, 20, 0));
		JPanel p3 = new JPanel(new FlowLayout(1, 0, 0));
		JPanel p4 = new JPanel(new FlowLayout(1, 0, 0));
		JPanel p5 = new JPanel(new FlowLayout(1, 0, 0));
		JPanel p6 = new JPanel(new FlowLayout(1, 0, 0));
		JPanel p7 = new JPanel(new FlowLayout(1, 100, 0));

		p1.add(nameJl);
		p1.add(nameJt);

		p2.add(boyJl);
		p2.add(boyJr);
		p2.add(girlJl);
		p2.add(girlJr);

		p3.add(phoneJl);
		p3.add(phoneJt);

		p4.add(cardJl);
		p4.add(cardJt);

		p5.add(passwordJl);
		p5.add(passwordJt);

		p6.add(passwordJl2);
		p6.add(passwordJt2);

		p7.add(registerJb);
		p7.add(returnJb);

		cp.add(p1);
		cp.add(p3);
		cp.add(p4);
		cp.add(p5);
		cp.add(p6);
		cp.add(p2);
		cp.add(p7);

		nameJt.addFocusListener(new FocusListener()
		{

			@Override
			public void focusGained(FocusEvent e)
			{
//				nameJt.setText("");
			}

			@Override
			public void focusLost(FocusEvent e)
			{
				String name = nameJt.getText();
				if (!v.isutf_8(name) && !v.emptyText(name))
				{
					JOptionPane.showMessageDialog(null, "������������");
				}
			}
		});

		phoneJt.addFocusListener(new FocusListener()
		{

			@Override
			public void focusGained(FocusEvent e)
			{
//				phoneJt.setText("");
			}

			@Override
			public void focusLost(FocusEvent e)
			{
				// TODO Auto-generated method stub
//				JOptionPane.showMessageDialog(null, text);
				String text = phoneJt.getText();
				if (!v.phoneVerify(text) && !v.emptyText(text))
				{
					JOptionPane.showMessageDialog(null, "�绰������������");
				}
			}
		});
		// ֻ������������
		phoneJt.setDocument(new DataVerify().newNumberTextField());

		cardJt.addFocusListener(new FocusListener()
		{

			@Override
			public void focusGained(FocusEvent e)
			{
//				cardJt.setText("");
			}

			@Override
			public void focusLost(FocusEvent e)
			{
				// TODO Auto-generated method stub
				String text = phoneJt.getText();
				if (!v.phoneVerify(text) && !v.emptyText(text))
				{
					JOptionPane.showMessageDialog(null, "���֤������������");
				}
			}
		});

		cardJt.setDocument(new DataVerify().newNumberTextField());

		passwordJt.addFocusListener(new FocusListener()
		{

			@Override
			public void focusGained(FocusEvent e)
			{
				// TODO Auto-generated method stub
				// �����ȡ����ʱ���õķ���
				passwordJt.setText("");
			}

			@Override
			public void focusLost(FocusEvent e)
			{
				// TODO Auto-generated method stub
				passWordVerify = passwordJt.getText();
				if (!v.amountPassword(passWordVerify) && !v.emptyText(passWordVerify))
				{
					JOptionPane.showMessageDialog(null, "������������");
				}
			}
		});

		passwordJt2.addFocusListener(new FocusListener()
		{

			@Override
			public void focusGained(FocusEvent e)
			{
				// TODO Auto-generated method stub
				// �����ȡ����ʱ���õķ���
				passwordJt2.setText("");
			}

			@Override
			public void focusLost(FocusEvent e)
			{
				// TODO Auto-generated method stub
				String passwordVerify = passwordJt2.getText();
				if (!v.samePassword(passWordVerify, passwordVerify) && !v.emptyText(passwordVerify))
				{
					JOptionPane.showMessageDialog(null, "�������벻һ��");
				}
			}
		});

		registerJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				// ��Ϣ��֤ �����ύ
				EnSure register = new EnSure();
				String name = nameJt.getText();
				String phone = phoneJt.getText();
				String password = passwordJt.getText();
				String password2 = passwordJt2.getText();
				String card = cardJt.getText();
				
				boolean gender = boyJr.isSelected();
				
				try
				{
					String r = register.register(name, phone, gender, password, password2, card);
					JOptionPane.showMessageDialog(null, r);
					new LoginWindow();
					dispose();
				} catch (Exception e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		returnJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				new LoginWindow();
				dispose();
			}
		});

		setBounds(850, 430, 380, 450);
		setVisible(true);
		setTitle("��������ע��ϵͳ");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args)
	{
		new RegisterWindow();
	}

}
