package salesforcetestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethod {

	public ChromeOptions option = new ChromeOptions();
    public ChromeDriver driver=new ChromeDriver(option);
	
    @Parameters({"url","username","password"})
    @BeforeMethod
    public void precondition(String URL, String uname, String pword) {
		 
		    option.addArguments("--disable-notifications");
	        driver.manage().window().maximize();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
	        driver.get(URL);
			
			driver.findElement(By.id("username")).sendKeys(uname);
			driver.findElement(By.id("password")).sendKeys(pword);
			driver.findElement(By.id("Login")).click();	

	}
    
    @AfterMethod
	 public void postcondition() {
		 driver.close();
	 }
}
