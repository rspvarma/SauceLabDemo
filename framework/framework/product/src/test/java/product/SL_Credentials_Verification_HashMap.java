package product;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SL_Credentials_Verification_HashMap extends MainTest
{
	@Test(dataProvider="dataobj")
	public void SL_Users(HashMap<String,String> input) throws IOException

	{
		LoginPage LP = appLaunch();
		LP.uname(input.get("uname"));
		LP.password(input.get("password"));
		LP.login();
	    String pageTitle=driver.getTitle();
	    Assert.assertEquals(pageTitle, "Swag Labs");
		Logout();


	}
	
	@DataProvider
	public Object[][] dataobj()	
	{
	 HashMap <String,String> User1 =new HashMap<String,String>();
	 User1.put("uname", "standard_user");
	 User1.put("password", "secret_Sauce");
	 
	 HashMap <String,String> User2 =new HashMap<String,String>();
	 User2.put("uname", "locked_out_user");
	 User2.put("password", "secret_Sauce");
	 
	 HashMap <String,String> User3 =new HashMap<String,String>();
	 User3.put("uname", "problem_user");
	 User3.put("password", "secret_Sauce");
	 
	 HashMap <String,String> User4 =new HashMap<String,String>();
	 User4.put("uname", "performance_glitch_user");
	 User4.put("password", "secret_Sauce");
	 
	 return new Object[][] {{User1},{User2},{User3},{User4}};	
	
			
	}
}
