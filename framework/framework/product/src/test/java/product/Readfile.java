package product;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Readfile {
	
	
	// to get Rowcount
	
	public static int getRowcount(String path) throws FileNotFoundException
	{
	 int rc=0;
	 try (Scanner Scanner=new Scanner(new File(path)))
	 {
		Scanner.useDelimiter("\n");
		while(Scanner.hasNext())
		{
			rc++;
			Scanner.next();
		}
	 }
	 
	return rc;
	 
	}
	
	// Method to read data from given csv file
	
	public String getValue(String path,int rc,int cc) throws FileNotFoundException
	{
		String V="";
		try (Scanner Scanner = new Scanner(new File(path)))
		{
			Scanner.useDelimiter("\n");
			for(int i=1;i<=rc;i++)
			{
				if(Scanner.hasNext())
					V=Scanner.next();
			}
		}
				
		return V.split(",") [cc-1];
		
	}

}