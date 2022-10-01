package com.vtechsolution.orangehrm.test_base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtechsolution.orangehrm.utility.ExcelDataProvider;
import com.vtechsolution.orangehrm.utility.configDataProvider;
import com.vtechsolution.orangehrm.utility.costantVariable;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;

	public static configDataProvider configDataProvider;
	public static ExcelDataProvider excelDataProvider;
	public static ExtentSparkReporter reporter;
	public static  ExtentReports extent;
	public static ExtentTest extentTest;
	@BeforeSuite
	public void init() {
		// configDataProvider = new configDataProvider();
		configDataProvider = new configDataProvider(costantVariable.configDataPath);
		excelDataProvider = new ExcelDataProvider(costantVariable.excelPath);
		reporter = new ExtentSparkReporter("./reports/extentreport.html");

		reporter.config().setDocumentTitle("Automation Test report");
		reporter.config().setReportName("RT Test report");
		reporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Host", "Local Host");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Test Cases", "RT");
		extent.setSystemInfo("TE", "Kamlesh");
	}

	@BeforeMethod
	@Parameters({ "brname" })

	public void setUp(@Optional("chrome") String browser) {

		if (browser.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browser.equals("firefox")) {
			// System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
		}

		else if (browser.equals("edge")) {
			// System.setProperty("webdriver.edge.driver", "./Drivers/edgedriver.exe");
			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();
		}

		else {
			System.out.println("Browser setup doesn't match with with required browser....");

		}

		// driver.get(url);
		// driver.get(configDataProvider.SearchKey("appUrl"));
		driver.get(configDataProvider.getAppUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {

		Thread.sleep(2000);
		try {
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void extentflush() {
		extent.flush();
	}
}
