package product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainTest {

	public WebDriver driver;
	public FileInputStream fis;

	public WebDriver intializeDriver() throws IOException {

		Properties pf = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\GlobalValues.properties");
		pf.load(fis);

		String browserName = pf.getProperty("browser");
		System.out.println(browserName);
		String URL = pf.getProperty("URL");

		if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver();
			driver = new FirefoxDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}

	public LoginPage appLaunch() throws IOException {
		driver = intializeDriver();
		LoginPage LP = new LoginPage(driver);
		return LP;

	}

	// *************

	// to get Rowcount

	public static int getRowcount(String path) throws FileNotFoundException {
		int rc = 0;
		try (Scanner Scanner = new Scanner(new File(path))) {
			Scanner.useDelimiter("\n");
			while (Scanner.hasNext()) {
				rc++;
				Scanner.next();
			}
		}

		return rc;

	}

	// Method to read data from given csv file

	public String getValue(String path, int rc, int cc) throws FileNotFoundException {
		String V = "";
		try (Scanner Scanner = new Scanner(new File(path))) {
			Scanner.useDelimiter("\n");
			for (int i = 1; i <= rc; i++) {
				if (Scanner.hasNext())
					V = Scanner.next();
			}
		}

		return V.split(",")[cc - 1];

	}

	// This method creates an PrintWriter object and returns it.
	// PrintWriter converts primitive data (int,float,char..etc) into the text
	// format

	public StringBuilder sb;
	public PrintWriter pw;

	public PrintWriter Writer() throws FileNotFoundException {
		String rp = System.getProperty("user.dir") + "\\Results\\SL_Testresultsfile.csv";
		PrintWriter Writer = new PrintWriter(new File(rp));
		return Writer;

	}

	public StringBuilder WriteResultFile() throws FileNotFoundException {
		pw = Writer();
		StringBuilder sb = new StringBuilder();

		sb.append("");
		sb.append("Testcase");
		sb.append(",");		
		sb.append("Status");
		sb.append("\n");

		return sb;

	}

	public void Logout() {
		driver.close();
	}

	public ChartPage chartPage() {
		ChartPage CP = new ChartPage(driver);
		return CP;
	}

	public CheckoutPage chkPage() {
		CheckoutPage CHK = new CheckoutPage(driver);
		return CHK;
	}

	public ConfirmPage cnfPage() {
		ConfirmPage CNF = new ConfirmPage(driver);
		return CNF;
	}

	public InventoryPage invPage() {
		InventoryPage IP = new InventoryPage(driver);
		return IP;
	}

	public ThankyouPage tyPage() {
		ThankyouPage TYP = new ThankyouPage(driver);
		return TYP;
	}
	
	// this method is used to take screenshots
	
	public void getScreenshots(String filename) throws IOException
	{
	 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\Results\\Screenshots"+filename+"_Screenshots.png"));
	 
	}

}
