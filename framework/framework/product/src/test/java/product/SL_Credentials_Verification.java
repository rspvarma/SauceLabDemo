package product;

import java.io.IOException;

import java.io.PrintWriter;

import org.testng.Assert;
import org.testng.annotations.Test;



public class SL_Credentials_Verification extends MainTest
{

	@Test
	public void SL_Users() throws IOException
	{
	String rpath=System.getProperty("user.dir")+"\\src\\main\\resources\\product\\data\\Inputfile.csv";
	System.out.println(rpath);
	StringBuilder ref=WriteResultFile();
	PrintWriter pw=Writer();
	
	int rfile=getRowcount(rpath);
	
	 for(int i=1;i<rfile;i++)
	 {
		 String tcn=getValue(rpath,i+1,1);
		 System.out.println("My testcase name :"+tcn);
		 String usn=getValue(rpath,i+1,2);
		 String pwd=getValue(rpath,i+1,3);
	 
		LoginPage LP = appLaunch();
		LP.uname(usn);
		LP.password(pwd);
		LP.login();
	    String pageTitle=driver.getTitle();
	    Assert.assertEquals(pageTitle, "Swag Labs");
	    //take a screenshot
	    getScreenshots(usn);
	    if(driver.getTitle()!="")
	    {
	    	ref.append(tcn);
	    	ref.append(",");
	    	ref.append("PASS");
	    	ref.append("\n");
	    }
	    else
	    {
	    	ref.append(tcn);
	    	ref.append(",");
	    	ref.append("FAIL");
	    	ref.append("\n");
	    }
	  
		Logout();		
	 }

	 pw.write(ref.toString());
	 pw.flush();
	 pw.close();
	 
	}
/*
	@DataProvider
	public Object[][] dataobj()	
	{
	Object[][] DD=new Object[4][2];
	//first user
	DD [0][0]="standard_user";
	DD [0][1]="secret_sauce";
	
	//second user
	DD [1][0]="locked_out_user";
    DD [1][1]="secret_sauce";
    
    // third user
    DD [2][0]="problem_user";
    DD [2][1]="secret_sauce";
    
    // fourth user
    
    DD [3][0]="performance_glitch_user";
    DD [3][1]="secret_sauce";
	
	return DD;
	
			
	}
	
*/

}