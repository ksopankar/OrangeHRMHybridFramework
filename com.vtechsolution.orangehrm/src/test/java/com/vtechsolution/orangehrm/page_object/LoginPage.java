package com.vtechsolution.orangehrm.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// repository

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = ("//input[@name='username' or @placeholder='Username']"))
	WebElement usernametxt;

	@FindBy(xpath = ("//input[@name='password' or @placeholder='Password']"))
	WebElement passwordtxt;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButtonTxt;

	@FindBy(xpath = "//div[@class= 'orangehrm-login-branding']/img")
	WebElement imgLogo;

	public boolean verifyOrangeHrmlogo() {

		try {
			return imgLogo.isDisplayed();

		} catch (Exception e) {
			return false;

		}

	}

	public void setusername(String username) {
		try {
			usernametxt.clear();
			usernametxt.sendKeys(username);
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	public void setpassword(String password) {
		try {
			passwordtxt.clear();
			passwordtxt.sendKeys(password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickonloginbtn() {

		try {
			loginButtonTxt.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
