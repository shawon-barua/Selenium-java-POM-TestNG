package pages;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CalculatorPage {
	private WebDriver driver;
	private static DecimalFormat df2 = new DecimalFormat(".##");

	@FindBy(xpath="//*[@id='currency-exchange-app']/div/div/div[2]/div[1]/form/div[1]/input")
	private WebElement sellTextBox;

	@FindBy(xpath="/html/body/main/article/section[1]/div/div/div/div/div[1]/div[3]/a")
	private WebElement rateButton;

	@FindBy(xpath="//*[@id='currency-exchange-app']/div/div/div[2]/div[1]/form/div[3]/input")
	private WebElement buyTextBox;

	@FindBy(xpath="//*[@id='currency-exchange-app']/div/div/div[2]/div[1]/form/div[1]/div/div[1]/span/span[2]/span")
	private WebElement currencyBox;
	
	@FindBy(xpath="/html//div[@id='currency-exchange-app']/div/div/div[2]/table/tbody/tr[1]/td[5]/span/span/span[2]")
	private WebElement differenceValue;

	@FindBy(xpath="/html//div[@id='currency-exchange-app']/div/div/div[2]/table/tbody/tr[1]/td[4]//span[@class='ng-binding']")
	private WebElement payseraAmount;;
	@FindBy (xpath="/html//div[@id='currency-exchange-app']/div/div/div[2]/table/tbody/tr[1]/td[5]//span[@class='ng-binding']")
	private WebElement swedbankAmount;

	@FindBy (xpath="//*[@id='currency-exchange-app']/div/div/div[2]/table/tbody/tr[1]/td[2]/span/span/span")
	private WebElement euroUsdRate;

	@FindBy (xpath="//*[@id='currency-exchange-app']/div/div/div[2]/table/tbody/tr[2]/td[2]/span/span/span")
	private WebElement gbpUsdRate;

	// constructor method
	public CalculatorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement sellTextBox() {
		return sellTextBox;
	}
	
	public WebElement buyTextBox() {
		return buyTextBox;
	}

	public WebElement getcurrencyBox() {
		return currencyBox;
	}

	public WebElement getRateButton() {
		return rateButton;
	}
	public WebElement getEuroUsdRate() {
		return euroUsdRate;
	}

	public WebElement getGbpUsdRate() {
		return gbpUsdRate;
	}
	public WebElement differenceValue() {
		return differenceValue;
	}
	
	public WebElement payseraAmount() {
		return payseraAmount;
	}
	public WebElement swedbankAmount()
	{
		return swedbankAmount;
	}


	// method for text change of sell and buy box
	public void sellBuyTextChange() throws InterruptedException {
		buyTextBox().sendKeys("100");

		Thread.sleep(1000);

		sellTextBox().click();
		Assert.assertEquals(sellTextBox().getText(), "");

		sellTextBox().sendKeys("100");
		buyTextBox().click();
		Assert.assertEquals(buyTextBox().getText(), "");

	}

	// method for loss claculate
	public BigDecimal ifLoss() {
		double x = Double.parseDouble(swedbankAmount().getText());
		double y = Double.parseDouble(payseraAmount().getText());
		BigDecimal loss=new BigDecimal(x-y).setScale(2,RoundingMode.HALF_DOWN);
		return  loss;
	}


}
