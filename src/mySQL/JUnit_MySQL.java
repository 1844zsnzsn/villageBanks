package mySQL;

/*
 * ���ݿ����
 */

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class JUnit_MySQL
{
//	@Test
	public void ConnTest()
	{
		Connection con;
		// �����������ݿ������
		Conn c = new Conn();
		// �����ݿ⽨������
		con = c.getConnection();
	}
	
//	@Test
	public void GradationTest()
	{
		String name = "������",name1 = "�Ŷ�";
		Gradation gra = new Gradation();
		gra.outName();
		if(gra.findSB(name))
		{
			System.out.println("find he/she");
		}else {
			System.out.println("not find he/she");
		}
		
		if(gra.findSB(name1))
		{
			System.out.println("find he/she");
		}else {
			System.out.println("not find he/she");
		}
	}
	
//	@Test
	public void RenewalTest() throws Exception
	{
		Gradation gra = new Gradation();
		gra.outName();
		String name = "��һ";
		String name1 = "����";
		String name2 = "����";
		String name3 = "��һ";
		Renewal ren = new Renewal()	;
		ren.add(name);
		gra.outName();
		ren.delete(name2);
		gra.outName();
		ren.change(name1, name3);
		gra.outName();
	}
	
//	@Test
	public void villageBanksMySQL_idTest() throws SQLException
	{
		villageBanksMySQL_id vid = new villageBanksMySQL_id();
		
		String telephone = "12345678901";
		if(vid.havaID(telephone)) {
			System.out.println("I find it");
		}else {
			System.out.println("sorry ");
		}
		  
		if(vid.isAccount()) {
			System.out.println("I find it");
		}else {
			System.out.println("sorry ");
		}
		System.out.println(vid.getVacancy_telephone(telephone));
//		vid.changeAccount(telephone);
		String vacany = Float.toString(vid.getVacancy_telephone(telephone));
		System.out.println(vacany);
		float telephonef = Float.parseFloat("5000000");
		System.out.println(telephonef+100);
		
		System.out.println(vid.haveId("123456789123456789"));
		
//		vid.transfer("12345678901", 1);
//		vid.transfer2("123456789123456789",2);
	}
	
	@Test
	public void villageBanksMySQL_userTest() throws Exception
	{
		VillageBanksMySQL_uer vu = new VillageBanksMySQL_uer();
		
		String name = "��ʮһ";
		String phone = "15844511177";
		String password = "tt759272..";
		String card = "220521111111111111";
		boolean gender = true;
//		vu.addRegister(name, phone, password, card,gender);
		if(vu.login_matching("12345678901"	, "123456"))
			System.out.println("login");
		
		if(vu.haveTelephone("12345678901"))
		{
			System.out.println("have");
		}else {
			System.out.println("haven't");
		}
		
		if(vu.truePassword("12345678901", "123456"))
		{
			System.out.println("true");
		}
		//�޸�����
//		vu.changePassword("12345678901", "123456");
		if(vu.haveName("12345678901", "��"))
			System.out.println("hava");
	
		if(vu.haveCard("12345678901","220521111111111111"))
			System.out.println("hava card");
//		vu.changeLoss0("12345678901");
//		vu.changeLoss1("12345678901");
		if(vu.isBoy("12345678901"))
			System.out.println("is boy");
		else {
			System.out.println("is girl");
		}
	
		vu.changeGender("12345678901", "��");
	}
	
}
