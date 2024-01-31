
package miniproject;
 
import java.io.IOException;

import java.util.ArrayList;

import java.util.HashSet;

import java.util.List;

import java.util.Set;
 
import org.openqa.selenium.By;

//import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
 
 
public class project {


	public static	WebDriver driver;


	public static void createDriver() {

		driver = DriverSetup.getWebDriver();

	}


	private static void configure() throws IOException {

		//excel sheet

		String file="C:\\Users\\2303862\\eclipse-workspace\\SeleniumTesting\\src\\test\\java\\miniproject\\Book1.xlsx";

		String m=utility.getCellData(file, "Sheet1", 0, 0);	

		String y = utility.getCellData(file, "Sheet1", 0, 1);

		String k =utility.getCellData(file, "Sheet1", 0, 2);

		//selecting car make

		Select sc = new Select(driver.findElement(By.name("make")));

		sc.selectByVisibleText(m);


		//selecting fuel type		

		List<WebElement> option = driver.findElements(By.xpath("//*[@id=\"tabs-1\"]/p[2]/input"));

		for(WebElement i : option) {

			if(i.getAttribute("value").equals(y)) {

				i.click();

				break;

			}

		}

//selecting optional features			

		driver.findElement(By.name("parksensor")).click();		

		

//selecting car color

		Select scm = new Select(driver.findElement(By.name("color")));

		scm.selectByVisibleText(k);

//clicking help 

		driver.findElement(By.xpath("//*[@id='helpbutton']")).click();

//clicking chat 

		driver.findElement(By.id("chatbutton")).click();

//clicking visit us

		driver.findElement(By.id("visitbutton")).click();
 
	}
 
	public static void handleWindows() {

		Set<String> a = new HashSet<String>();

		a = driver.getWindowHandles();

		System.out.println(a.size());

		List<String> b = new ArrayList<String>(a);

		System.out.println(b);

		//finding visit us is there or not

		for(String windowId: b) {

			String title=driver.switchTo().window(windowId).getTitle();
			
			if(title.equals("Visit Us")) {

				System.out.println("Found");

				driver.close();

				break;

			}

		}

		//navigating back to main browser window
		String main=b.get(0);

		driver.switchTo().window(main);
		//driver.quit();

		}

		public static void main(String[] args) throws IOException{

			project.createDriver();

			project.configure();

			project.handleWindows();

	}
 
}