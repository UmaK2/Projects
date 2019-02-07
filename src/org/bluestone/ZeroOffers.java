package org.bluestone;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ZeroOffers 
{
	static
	{
		
		//System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

	}


	public static void main(String[] args) throws InterruptedException 
	{

	WebDriver driver = new ChromeDriver();
	driver.manage().window().fullscreen();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.bluestone.com/");
	WebElement webEleRings = driver.findElement(By.xpath("//li[@class='menuparent offers-menuparent pull-right']/a[.='Offers ']"));
	Actions action=new Actions(driver);
	action.moveToElement(webEleRings).perform();
	Thread.sleep(1000);

	driver.findElement(By.xpath("//div/nav/ul/li/div/ul/li/span[.='0% Making Charge']")).click();
	List<WebElement> allElement = driver.findElements(By.xpath("//div[@id='product-display']/descendant::span[.='0% making charge']"));
	for(WebElement element:allElement)
	{
		String ZeroOfferText = element.getText();
		System.out.println("Zero Offer"+ZeroOfferText);
		if(ZeroOfferText.equalsIgnoreCase("0% MAKING CHARGE"))
		{
			System.out.println("Its contain o% discount");
		}
		else {
			System.out.println("its not contains");
		}
	}
	}
}
