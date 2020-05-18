package villageBanks;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Window extends JFrame
{
	private String telephone = null;

	public Window(String telephone)
	{
		JButton checkJb = new JButton("����ѯ");
		JButton changePasswordJb = new JButton("�޸�����");
		JButton transferJb = new JButton("ת        ��");
		JButton lossJb = new JButton("��        ʧ");
		JButton noLossJb = new JButton("ȡ        ��");
		JButton appointmentJb = new JButton("ԤԼȡ��");
		JButton rechargeJb = new JButton("���ѳ�ֵ");
		JButton changeInformationJb = new JButton("��Ϣ�޸�");
		JButton transferRecorJb = new JButton("ת�˼�¼");
		JButton exitJb = new JButton("��        ��");

		JLabel jl = new JLabel("", JLabel.CENTER);
		URL url = LoginWindow.class.getResource("up3.png");
		Icon icon = new ImageIcon(url);
		jl.setIcon(icon);
		jl.setHorizontalAlignment(SwingConstants.CENTER);    
		jl.setOpaque(true);
		
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(5, 1, 10, 10));

		JPanel p1 = new JPanel(new FlowLayout(1, 20, 0));
		JPanel p2 = new JPanel(new FlowLayout(1, 20, 0));
		JPanel p3 = new JPanel(new FlowLayout(1, 20, 0));
		JPanel p4 = new JPanel(new FlowLayout(1, 20, 0));
		JPanel p5 = new JPanel(new FlowLayout(1, 20, 0));

		p5.add(jl);
		
		p1.add(checkJb);
		p1.add(transferJb);
		p1.add(lossJb);

		p2.add(changePasswordJb);
		p2.add(transferRecorJb);
		p2.add(noLossJb);

		p3.add(rechargeJb);
		p3.add(appointmentJb);
		p3.add(changeInformationJb);

		p4.add(exitJb);

		cp.add(p5);
		cp.add(p1);
		cp.add(p2);
		cp.add(p3);
		cp.add(p4);

		transferRecorJb.setEnabled(false);
		
		appointmentJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, "ԤԼ�ɹ���������Ա���������ȡ����ϵ");
			}
		});

		changeInformationJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				// �����Ի���
//				JOptionPane.showMessageDialog(null, "�����Ի���");
				new ChangeInformationWindow(telephone);
				dispose();
			}
		});

		changePasswordJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				new ChangePasswordWindow(telephone);
				dispose();
			}
		});

		checkJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				new CheckWindow(telephone);
				dispose();
			}
		});

		exitJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				new LoginWindow();
				dispose(); // �رյ�ǰ����
			}
		});

		lossJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				new NolossWindow(telephone);
				dispose();
			}
		});

		noLossJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				new NolossWindow(telephone);
				dispose();
			}
		});

		rechargeJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				new RechargeWindow(telephone);
				dispose();
			}
		});

		transferJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				new TransferWindow(telephone);
				dispose(); // �رյ�ǰ����

			}
		});

		transferRecorJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				// �����Ի���
//				JOptionPane.showMessageDialog(null, "�����Ի���");
			}
		});

		setBounds(850, 430, 380, 450);
		setVisible(true);
		setTitle("��������ϵͳ");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	}

	public static void main(String[] args)
	{
		new Window("12345678901");
	}
}
