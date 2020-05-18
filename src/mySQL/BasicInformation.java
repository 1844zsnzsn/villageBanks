package mySQL;

/*
 * 数据库连接基本信息
 */
public class BasicInformation
{
	private String url = null;
	private String userName = null;
	private String password = null;
	private String SQL = null;
	private String form = null;
	
	public BasicInformation()
	{
		this.url = "jdbc:mysql://localhost:3306/";
		this.userName = "root";
		this.password = "root";
		this.SQL = "villagebanks";
		this.form = "user";
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getSQL()
	{
		return SQL;
	}
	public void setSQL(String sQL)
	{
		SQL = sQL;
	}
	public String getForm()
	{
		return form;
	}
	public void setForm(String form)
	{
		this.form = form;
	}
	
	
}
