package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pages.CalculatorPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.CountryOptionPage;
import utils.BrowserSetting;
import static variables.AllVariables.*;

public class CountrySelectTest {
	private WebDriver driver;
	private JavascriptExecutor js;
	private	CalculatorPage home;
	private CountryOptionPage country;
	private WebDriverWait wait;
	private	BrowserSetting bs;

	@BeforeClass
	public void setUp()
	{
		bs = new BrowserSetting();
		driver = bs.BrowserSettings();
		wait = new WebDriverWait (driver,15);

		js= (JavascriptExecutor) driver;
		home = new CalculatorPage(driver);
		country =new CountryOptionPage(driver);

	}
	@Test (priority = 1)
	// select country and verify rate chnaged
	public void selectCountry() throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOf(home.getRateButton()));
		home.getRateButton().click();
		wait.until(ExpectedConditions.visibilityOf(home.getEuroUsdRate()));

		String euro =home.getEuroUsdRate().getText();

		js.executeScript("arguments[0].scrollIntoView(true);", country.getDropdown());
		country.getDropdown().click();

		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(country.getCountryDropdown()));
		Thread.sleep(1000);

		country.getCountryDropdown().click();
		wait.until(ExpectedConditions.visibilityOf(country.getCountry()));
		Thread.sleep(1000);

		country.getCountry().click();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOf(home.getRateButton()));
		home.getRateButton().click();

		//js.executeScript("arguments[0].scrollIntoView(true);", home.getcurrencyBox());
		wait.until(ExpectedConditions.visibilityOf(home.getcurrencyBox()));
		//js.executeScript("arguments[0].scrollIntoView(true);",home.sellTextBox());
		//js.executeScript("window.scrollBy(0, -250)", "");
		// check currancy changed
		Assert.assertEquals(home.getcurrencyBox().getText(),"GBP");
		wait.until(ExpectedConditions.visibilityOf(home.getGbpUsdRate()));
		Assert.assertNotEquals(home.getGbpUsdRate().getText(),euro);


		//driver.quit();

	}

	@AfterClass
	public void finish()
	{
		driver.quit();
	}

}
