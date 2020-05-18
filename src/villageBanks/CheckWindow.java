package villageBanks;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import mySQL.villageBanksMySQL_id;

public class CheckWindow extends JFrame
{	
	
	public CheckWindow(String telephone)
	{
		villageBanksMySQL_id vid = new villageBanksMySQL_id();
		vid.setTelephone(telephone);
		String vacany = Float.toString(vid.getVacancy_telephone(telephone));
		
		JLabel sumJl = new JLabel("余    额");
		
		JTextField sumJt = new JTextField(vacany,20);
		
		JButton returnJb = new JButton("返    回");
		
		setLayout(null); 
		
		sumJl.setBounds(165, 55, 50, 100);
		sumJt.setBounds(60, 150, 270, 35);
		returnJb.setBounds(133,290, 100, 30);
		
		Container cp=getContentPane();
		
		cp.add(sumJl);
		cp.add(sumJt);
		cp.add(returnJb);
		
		
		returnJb.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				new Window(telephone);
				dispose(); // 关闭当前窗口
			}
		});
		
		setBounds(850,430,380,450);		
		setVisible(true);
		setTitle("村镇银行查询余额系统");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		new CheckWindow("12345678901");
	}
}
