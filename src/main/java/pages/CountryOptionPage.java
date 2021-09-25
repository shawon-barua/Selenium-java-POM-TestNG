package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CountryOptionPage {

	private WebDriver driver;

	@FindBy(className = "dropup")
	private WebElement dropdown;

	@FindBy (id = "countries-dropdown")
	private WebElement country_dropdown;

	@FindBy(xpath="/html/body/div[2]/div[2]/div/form/div[1]/div/div/ul/li[8]/a")
	private WebElement country;


	// constructor method
	public CountryOptionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getCountryDropdown () {

		return country_dropdown;
	}

	public WebElement getCountry() {
		return country;
	}

}
