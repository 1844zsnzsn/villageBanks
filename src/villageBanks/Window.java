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
		JButton checkJb = new JButton("余额查询");
		JButton changePasswordJb = new JButton("修改密码");
		JButton transferJb = new JButton("转        账");
		JButton lossJb = new JButton("挂        失");
		JButton noLossJb = new JButton("取        挂");
		JButton appointmentJb = new JButton("预约取款");
		JButton rechargeJb = new JButton("话费充值");
		JButton changeInformationJb = new JButton("信息修改");
		JButton transferRecorJb = new JButton("转账记录");
		JButton exitJb = new JButton("退        出");

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
				JOptionPane.showMessageDialog(null, "预约成功，工作人员将尽快和您取得联系");
			}
		});

		changeInformationJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				// 弹出对话框
//				JOptionPane.showMessageDialog(null, "弹出对话框");
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
				dispose(); // 关闭当前窗口
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
				dispose(); // 关闭当前窗口

			}
		});

		transferRecorJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				// 弹出对话框
//				JOptionPane.showMessageDialog(null, "弹出对话框");
			}
		});

		setBounds(850, 430, 380, 450);
		setVisible(true);
		setTitle("村镇银行系统");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	}

	public static void main(String[] args)
	{
		new Window("12345678901");
	}
}
