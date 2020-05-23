package villageBanks;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.URL;

public class LoginWindow extends JFrame
{
	DataVerify v = new DataVerify();


	public LoginWindow()
	
	{
		// TODO Auto-generated constructor stub
		JLabel phoneJl = new JLabel("�ֻ����룺");
		JLabel passwordJl = new JLabel("  ��    �룺");
		
		JLabel jl = new JLabel("����һ��JFrame����", JLabel.CENTER);
		URL url = LoginWindow.class.getResource("background.png");
		Icon icon = new ImageIcon(url);
		jl.setIcon(icon);
		jl.setHorizontalAlignment(SwingConstants.CENTER);    
		jl.setOpaque(true);
		
		JTextField phoneJt = new JTextField(20);
		JPasswordField passwordJt = new JPasswordField(20);

		JButton loginJb = new JButton("��½");
		JButton registerJb = new JButton("ע��");	

		Container cp = getContentPane();
		
		jl.setBounds(0,0, 380,450);
		
		phoneJl.setBounds(30, 55, 80, 80);
		phoneJt.setBounds(110, 75, 220, 40);

		passwordJl.setBounds(35, 190, 80, 20);
		passwordJt.setBounds(110, 180, 220, 40);		
		
		loginJb.setBounds(70,290,80, 40);
		registerJb.setBounds(220,290, 80, 40);
		
		cp.add(phoneJl);
		cp.add(phoneJt);
		cp.add(passwordJl);
		cp.add(passwordJt);
		cp.add(loginJb);
		cp.add(registerJb);
		cp.add(jl);
		
		phoneJt.addFocusListener(new FocusListener()
		{

			@Override
			public void focusGained(FocusEvent e)
			{
				phoneJt.setText("");
			}

			@Override
			public void focusLost(FocusEvent e)
			{
//				JOptionPane.showMessageDialog(null, "�ı���ʧȥ����");
				String text = phoneJt.getText();
				if (!v.phoneVerify(text) && !v.emptyText(text))
				{
					JOptionPane.showMessageDialog(null, "�绰������������");
				}
			}
		});
		phoneJt.setDocument(new DataVerify().newNumberTextField());

		passwordJt.addFocusListener(new FocusListener()
		{

			@Override
			public void focusGained(FocusEvent e)
			{
				passwordJt.setText("");
			}

			@Override
			public void focusLost(FocusEvent e)
			{
				// TODO Auto-generated method stub
				String passWordVerify = passwordJt.getText();
				if (!v.amountPassword(passWordVerify) && !v.emptyText(passWordVerify))
				{
					JOptionPane.showMessageDialog(null, "����������������ӦΪ6-20λ��");
				}
			}
		});

		loginJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				// �����Ի���
//				JOptionPane.showMessageDialog(null, "�����Ի���");

				// �ֻ������������ݿ�������ƥ��
				EnSure sure = new EnSure();
				String telephone = phoneJt.getText();
				String password = passwordJt.getText();

				String l = sure.login(telephone, password);
				if (l.equalsIgnoreCase("��½�ɹ�"))
				{
					new Window(telephone);
					dispose(); // �رյ�ǰ����
				} else
				{
					JOptionPane.showMessageDialog(null, l);
				}
			}
		});

		registerJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				new RegisterWindow();
				dispose();
			}
		});

		setBounds(850, 430, 380, 450);
		setVisible(true);
		setTitle("�������е�½ϵͳ");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args)
	{
		new LoginWindow();
	}
}
