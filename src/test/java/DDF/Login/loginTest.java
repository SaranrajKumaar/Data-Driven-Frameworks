package DDF.Login;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DDF.Excel.DataDriven;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginTest extends DataDriven {
	
	public WebDriver driver ;
	@Test(dataProvider = "validCrendtial")
	public void loginwithValidcredentials(String Email, String password,String productName) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/client");
		driver.manage().window();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("userEmail")).sendKeys(Email);
		driver.findElement(By.id("userPassword")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@name='search'])[2]")).sendKeys(productName);
		driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[4]")).click();
		driver.close();

		System.out.println("Hello World");
	}
	
	
	
	
	
	
	
	@DataProvider(name ="validCrendtial")
	public Object[][] gettestdataFromExcel() throws IOException {
		
		Object[][] data =DataDriven.getTestDataFromExcel("login");
		
		
		
		return data;
	}
	

	
	



}
