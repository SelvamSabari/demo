package miniproject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup {
    public static WebDriver driver;
    
    public static WebDriver getWebDriver() {
    	// TODO Auto-generated method stub
    	WebDriver driver = new ChromeDriver(); 	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.get("http://cookbook.seleniumacademy.com/Config.html");
    	driver.manage().window().maximize();
    	return driver;
    }
}

