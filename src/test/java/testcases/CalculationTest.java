package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CalculatorPage;
import utils.BrowserSetting;
import java.math.BigDecimal;

public class CalculationTest extends BrowserSetting {
private WebDriver driver;
private JavascriptExecutor js;
private	CalculatorPage home;
private	BrowserSetting bs;
private WebDriverWait wait;
@BeforeClass
	public void setUp()
	{
		bs = new BrowserSetting();
		driver = bs.BrowserSettings();
		wait = new WebDriverWait(driver,15);

		js= (JavascriptExecutor) driver;
		home = new CalculatorPage(driver);
	}


	@Test (priority = 2)
	public void sellBuyInputTest() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(home.getRateButton()));
		home.getRateButton().click();

		wait.until(ExpectedConditions.visibilityOf(home.sellTextBox()));

		home.sellTextBox().isEnabled();
		home.buyTextBox().isDisplayed();
		home.sellBuyTextChange();

	}

	@Test (priority = 1)
	public void lossExchange() {
		BigDecimal value=home.ifLoss();
		BigDecimal zero = new BigDecimal("0");
		int result = value.compareTo(zero);
		if (result==(-1))
		{
			Assert.assertEquals(home.differenceValue().getText(),"("+value+")");

		}
		else
		driver.quit();

	}

	@AfterClass
	public void closeDriver()
	{
		driver.quit();
	}



}
