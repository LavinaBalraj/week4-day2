package salesforcetestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewLegal extends ProjectSpecificMethod{

	@DataProvider(name="fetchdata")
	public String[][] sendata(){
	String[][] data=new String[2][2];
	data[0][0]="Testleaf";
	data[0][1]="Salesforces";
			
	return data;
	
	}
	@Test(dataProvider="fetchdata")
	public void runnewleal(String Cname, String description) throws InterruptedException {
		
		
		
		//Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		//Click View All and 
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(3000);
		
		//Pass the input "Legal Entities" in the search box 
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Legal Entities");
		
		//- Click View All and click Legal Entities from App Launcher
		driver.findElement(By.xpath("//span[@class='slds-truncate label-display']//mark[text()='Legal Entities']")).click();
		
		//- Click on the Dropdown icon in the legal Entities tab
		//driver.findElement(By.xpath("//div[@class='slds-context-bar__label-action slds-p-left_none slds-p-right_x-small']")).click();
		
		//- Click on New Legal Entity
		//driver.findElement(By.xpath("//span[contains(text(),'New Legal Entity')]")).click();
		driver.findElement(By.xpath("//div[text()='New']")).click();
		
			
		//- Enter the Company name as 'TestLeaf'.
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys(Cname);
		
		//- Enter Description as 'Salesforces'.
		driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys(description);
		
		
		Thread.sleep(3000);
		
		Actions toScroll = new Actions(driver);
		WebElement status= driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value']"));
		driver.executeScript("arguments[0].click();", status);
		
		//driver.findElement(By.xpath("//span[@class='slds-truncate' and text()='Active']")).click();
		//driver.findElement(By.xpath("//span[@class='slds-truncate']")).click();
		//driver.findElement(By.xpath("(//span[text()='Active'])[2]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand' and text()='Save']")).click();
		boolean alert = driver.findElement(By.xpath("//h2[text()='We hit a snag.']")).isDisplayed();
		  String alertmsg = driver.findElement(By.xpath("//h2[text()='We hit a snag.']")).getText();
		  if (alert) {
		   System.out.println("Success confirmation is succesfully displayed! and the legal name is: " + alertmsg);
		  } else {
		   System.out.println("Success confirmation is not displaying");
		  }
	}

}
