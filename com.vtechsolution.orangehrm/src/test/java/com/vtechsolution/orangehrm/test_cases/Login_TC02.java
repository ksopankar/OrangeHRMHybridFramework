package com.vtechsolution.orangehrm.test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtechsolution.orangehrm.page_object.LoginPage;
import com.vtechsolution.orangehrm.test_base.TestBase;
import com.vtechsolution.orangehrm.utility.ExcelDataProvider;

public class Login_TC02 extends TestBase {

	LoginPage lp;

	@Test
	public void verifyloginTestTC_01() throws InterruptedException {

		lp = new LoginPage(driver);

//		lp.setusername(ExcelDataProvider.getStringCellData(0, 1, 0));
//		lp.setpassword(ExcelDataProvider.getStringCellData(0, 1, 1));

		lp.setusername(ExcelDataProvider.getStringCellData("login", 1, 0));
		lp.setpassword(ExcelDataProvider.getStringCellData("login", 1, 1));

		lp.clickonloginbtn();

		if (driver.getPageSource().contains("dashboard")) {
			Assert.assertTrue(true);
			System.out.println("Login Success..!!!!");
		}

		else {
			System.out.println("Login Failed..!!!!");
			Assert.assertTrue(false);
		}
	}

}
