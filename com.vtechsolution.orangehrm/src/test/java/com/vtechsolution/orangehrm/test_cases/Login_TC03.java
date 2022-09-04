package com.vtechsolution.orangehrm.test_cases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtechsolution.orangehrm.page_object.LoginPage;
import com.vtechsolution.orangehrm.test_base.TestBase;
import com.vtechsolution.orangehrm.utility.ExcelDataProvider;

public class Login_TC03 extends TestBase {

	@Test(dataProvider = "getData")
	public void verifyLogin(String username, String password) {
		LoginPage lp = new LoginPage(driver);

		lp.setusername(username);
		lp.setpassword(password);

		System.out.println(username);
		System.out.println(password);

		lp.clickonloginbtn();

		if (driver.getPageSource().contains("dashboard")) {
			Assert.assertTrue(true);
			System.out.println("Login Success..!!!!");
		} 
		
		else if (driver.getPageSource().contains("Invalid credentials")) {
			Assert.assertTrue(true);
			System.out.println("Invalid credentials Login Unsuccessful..!!!!");
		}

		else if (driver.getPageSource().contains("Invalid credentials")) {
			Assert.assertTrue(true);
			System.out.println("Invalid credentials Login Unsuccessful..!!!!");
		}
		
		else {
			System.out.println("Login Failed..!!!!");
			Assert.assertTrue(false);
		}
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = ExcelDataProvider.getExcelData("login1");
		return data;
	}
}
