package utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import dataReader.ConfigFileReader;

import static variables.UrlLink.*;

public class BrowserSetting {
	//public static WebDriver driver = null;
	ConfigFileReader configFileReader;
	public WebDriver BrowserSettings() {
		configFileReader= new ConfigFileReader();
		WebdriverSettings wd = new WebdriverSettings();
		WebDriver driver = wd.settings();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(configFileReader.getApplicationUrl());
		return driver;
	}

}
