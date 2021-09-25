package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverSettings {
	
	public WebDriver settings() {
		System.setProperty("webdriver.chrome.driver", "./src/resource/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}

}
