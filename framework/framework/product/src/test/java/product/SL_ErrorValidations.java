package product;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


public class SL_ErrorValidations extends MainTest{
	
	@Test(groups="ErrorValidations")
	public void SL_Username_MIssing() throws IOException
	{
		LoginPage LP = appLaunch();
		LP.uname("");
		LP.password("secret_sauce");
		LP.login();
		Assert.assertEquals(LP.errmsg(),"Epic sadface: Username is required");
		Logout();
		
	}
	
	@Test(groups="ErrorValidations")
	public void SL_Password_Missing() throws IOException
	{
		LoginPage LP = appLaunch();
		LP.uname("standard_user");
		LP.password("");
		LP.login();
		Assert.assertEquals(LP.errmsg(),"Epic sadface: Password is required");
		Logout();
	}
	
	@Test(groups="ErrorValidations")
	public void SL_Wrong_Credentials() throws IOException
	{
		LoginPage LP = appLaunch();
		LP.uname("standard_user2");
		LP.password("secret");
		LP.login();
		Assert.assertEquals(LP.errmsg(),"Epic sadface: Username and password do not match any user in this service");
		Logout();
	}

}
