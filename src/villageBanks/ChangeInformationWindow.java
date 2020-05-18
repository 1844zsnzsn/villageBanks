package villageBanks;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import mySQL.VillageBanksMySQL_uer;
import mySQL.villageBanksMySQL_id;

public class ChangeInformationWindow extends JFrame
{
	private String telephone = null;
	
	public ChangeInformationWindow(String telephone)
	{
		VillageBanksMySQL_uer vu = new VillageBanksMySQL_uer();
		this.telephone = telephone;
		
		JLabel genderJl = new JLabel("  性    别：");
		JLabel girlJl = new JLabel("女");
		JLabel boyJl = new JLabel("男");
		JLabel phoneJl = new JLabel("手机号码：");

		JRadioButton boyJr = new JRadioButton();
		JRadioButton girlJr = new JRadioButton();

		ButtonGroup group = new ButtonGroup();

		JButton registerJb = new JButton("修改");
		JButton returnJb = new JButton("返回");

		JTextField phoneJt = new JTextField(telephone, 20);

		Container cp = getContentPane();
		cp.setLayout(new GridLayout(4, 1, 10, 10));

		group.add(boyJr);
		group.add(girlJr);

		if (vu.isBoy(telephone))
		{
			boyJr.setSelected(true);
		} else
		{
			girlJr.setSelected(true);
		}

		JPanel p1 = new JPanel(new FlowLayout(1, 0, 0));
		JPanel p2 = new JPanel(new FlowLayout(1, 20, 0));
		JPanel p3 = new JPanel(new FlowLayout(1, 100, 0));
		JPanel p4 = new JPanel(new FlowLayout(1, 0, 0));

		p1.add(phoneJl);
		p1.add(phoneJt);

		p2.add(boyJl);
		p2.add(boyJr);
		p2.add(girlJl);
		p2.add(girlJr);

		p3.add(registerJb);
		p3.add(returnJb);

		cp.add(p4);
		cp.add(p1);
		cp.add(p2);
		cp.add(p3);

//		phoneJt.setDocument(new DataVerify().newNumberTextField());

		returnJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				new Window(getTelephone());
				dispose();
			}
		});
		
		registerJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String phone = phoneJt.getText();
				EnSure sure = new EnSure();
				String c = null;
				//手机号码  性别
				try
				{
					if(boyJr.isSelected())
					{
						c = sure.ChangeInformation(telephone, true, phone);
					}else {
						c = sure.ChangeInformation(telephone, false, phone);
					}
					setTelephone(phone);
					JOptionPane.showMessageDialog(null, c);
					new Window(getTelephone());
					dispose();
				} catch (Exception e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		setBounds(850, 430, 380, 450);
		setVisible(true);
		setTitle("村镇银行注册系统");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	
	public String getTelephone()
	{
		return telephone;
	}


	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}


	public static void main(String[] args)
	{
		new ChangeInformationWindow("12345678901");
	}
}
