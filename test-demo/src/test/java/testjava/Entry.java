package testjava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Entry
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions chrome_options = new ChromeOptions();
		
		chrome_options.setExperimentalOption("useAutomationExtension", false);
		chrome_options.addArguments("--no-sandbox");
		chrome_options.addArguments("--disable-dev-shm-usage");
		
		WebDriver driver = new ChromeDriver(chrome_options);
		
		driver.get("http://www.google.com");

		WebElement searchField = driver.findElement(By.id("lst-ib"));
		searchField.sendKeys("pluralsight");
		searchField.submit();
	}
}
