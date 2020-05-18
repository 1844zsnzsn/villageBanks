package villageBanks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VillageBanksJUnit
{

	@Test
	void DataVerifyTest()
	{
		DataVerify v = new DataVerify();
		String phone = "12345678901";
		if(v.phoneVerify(phone)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		String card = "220521199911187410";
		if(v.cardVerify(card)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		String password = "tt759272..";
		String password2 = "tt759272..";
		if(v.samePassword(password, password2)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		if(v.amountPassword(password)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		String text = "";
		if(v.emptyText(text)) {
			System.out.println("û������");
		}else {
			System.out.println("������");
		}
		
		String name = "����";
		if(v.isutf_8(name)) {
			System.out.println("������");
		}else {
			System.out.println("��ȫΪ����");
		}
	}
	
	

}
