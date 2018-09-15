package testjava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
	
	static ChromeOptions chrome_options=new ChromeOptions();
	static WebDriver driver;
	
	static{
System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions chrome_options = new ChromeOptions();
		
		chrome_options.setExperimentalOption("useAutomationExtension", false);
		chrome_options.addArguments("--no-sandbox");
		chrome_options.addArguments("--disable-dev-shm-usage");
		
		driver = new ChromeDriver(chrome_options);
	}
	
	public static void goTo(String url) {
		driver.get(url);
	}
	
	public static String  title() {
		return driver.getTitle();
	}
	public static void close() {
		driver.close();
	}

}
