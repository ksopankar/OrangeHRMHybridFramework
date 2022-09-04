package com.vtechsolution.orangehrm.test_cases;




import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtechsolution.orangehrm.page_object.LoginPage;
import com.vtechsolution.orangehrm.test_base.TestBase;

public class Login_TC01 extends TestBase {

//	@Test
//	public void logintest() {
//
//		driver.findElement(By.xpath("//input[@name='username' or @placeholder='Username']")).sendKeys("Admin");
//		driver.findElement(By.xpath("//input[@name='password' or @placeholder='Password']")).sendKeys("admin123");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();

	@Test(priority = 1)
	public void verifyOrangeHrmLogoTC_02() throws InterruptedException {

		LoginPage lp = new LoginPage(driver);
		Thread.sleep(2000);

		if (lp.verifyOrangeHrmlogo()) {
			Assert.assertTrue(true);
			System.out.println("Orange Hrm Logo Verified...!!!");
		} else {

			System.out.println("Orenge Hrm logo Not Displayed....??");
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 2)
	public void VerifyOrangeHrmPageTitleTC_03() {

		if (driver.getTitle().equals("OrangeHRM")) {

			Assert.assertTrue(true);
			System.out.println("Orange HRM Page Title Verified On Login Page...");
		} else {
			System.out.println("Orange HRM Page Title On Matched...??");
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 4)
	public void verifyloginTestTC_01() throws InterruptedException {

		LoginPage lp = new LoginPage(driver);

//		lp.setusername(configDataProvider.SearchKey("username"));
//		lp.setpassword(configDataProvider.SearchKey("password"));
		
		Thread.sleep(2000);
		lp.setusername(configDataProvider.getUserName());
		System.out.println(configDataProvider.getUserName());
		lp.setpassword(configDataProvider.getPassword());
		System.out.println(configDataProvider.getPassword());

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

//	@Test(priority = 3)
//	public void verifyloginTestTC_01() {
//
//		LoginPage lp = new LoginPage(driver);
//
//		lp.setusername("Admin");
//		lp.setpassword("admin123");
//
//		lp.clickonloginbtn();
//
//		if (driver.getPageSource().contains("dashboard")) {
//			Assert.assertTrue(true);
//			System.out.println("Login Success..!!!!");
//		}
//
//		else {
//			System.out.println("Login Failed..!!!!");
//			Assert.assertTrue(false);
//		}
//	}
}
