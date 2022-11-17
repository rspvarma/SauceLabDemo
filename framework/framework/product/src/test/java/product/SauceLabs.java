package product;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceLabs extends MainTest {

	@Test
	public void PurchaseOrder() throws IOException {

		// Login Page
		LoginPage LP = appLaunch();

		LP.uname("standard_user");
		LP.password("secret_sauce");
		LP.login();

		// InventoryPage
		InventoryPage IP = invPage();
		boolean invpage = IP.backPack.isEnabled();
		if (invpage == true) {

			// select items to buy

			IP.backPack();
			IP.bolt_Tshirt();
			IP.bikeLight();

			// click on cart to verify the items

			boolean cartpg = IP.chartLink.isEnabled();
			if (cartpg == true) {

				IP.gotoChart();
				ChartPage CRT = chartPage();

				CRT.checkout();

				// add checkout info

				CheckoutPage CHK = chkPage();
				boolean chkoutpg = CHK.firstName.isEnabled();
				if (chkoutpg == true) {
					CHK.firstName("Pavan");
					CHK.lastName("Rajasagi");
					CHK.zipCode("30328");
					CHK.btncontinue();

					// confirm order
					ConfirmPage CNF = cnfPage();
					boolean cnfrmpg = CNF.Btn_finish.isEnabled();
					if (chkoutpg == true) {

						CNF.finish();
						ThankyouPage TYP = tyPage();
						String tymsg = TYP.thankyouMsg.getText();
						System.out.println(tymsg);

						String ordermsg = TYP.orderMsg.getText();
						System.out.println(ordermsg);

						driver.close();

					}
				}
			}
		}

		else {
			driver.close();

		}
	}
}