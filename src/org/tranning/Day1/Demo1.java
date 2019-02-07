package org.tranning.Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Demo1 {
	static
	{
		
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

	}

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.urbanladder.com/");
		driver.findElement(By.partialLinkText("Close")).click();
		String xp="//div/ul[@class='topnav bodytext']/li";
		List<WebElement> listOfMenus = driver.findElements(By.xpath(xp));
		int size=listOfMenus.size();
		Thread.sleep(2000);
		ArrayList<String>data=new ArrayList<String>();
		Actions action=new Actions(driver);
		
		for(int i=0;i<size;i++)
		{
			String text = listOfMenus.get(i).getText();
			System.out.println("text is "+text);
			
			action.moveToElement(listOfMenus.get(i)).perform();
			Thread.sleep(2000);
			
//			String xps="//div/div/ul[@class='inline-list left']";
//			
//			 List<WebElement> subMenusItems = driver.findElements(By.xpath(xps));
//			 for(int j =0;j<subMenusItems.size();j++)
//			 {
//				 String titleText = subMenusItems.get(j).getText();
//				// System.out.println("tile is :"+titleText);
//				 data.add(titleText);
//			 }
//			 System.out.println("the title data"+data);
			 
		}
		driver.close();

	}

}
