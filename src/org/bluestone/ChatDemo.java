package org.bluestone;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChatDemo 

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
	Thread.sleep(1000);
	driver.switchTo().frame("wiz-iframe");
	//String xp="div[@id='contentDiv']/span[@class='CT_BannerClose']";
	//Thread.sleep(500);
	
	driver.findElement(By.xpath("//div[@id='contentDiv']/span")).click();
	driver.switchTo().defaultContent();
	driver.switchTo().frame("livechat-compact-view");
	Thread.sleep(500);
	//driver.findElement(By.xpath("//div[@id='content-container']/descendant::span[@id='open-icon']")).click();
	//driver.findElement(By.id("icon-maximize")).click();
	driver.findElement(By.id("open-label")).click();
	driver.switchTo().defaultContent();
	driver.switchTo().frame("livechat-full-view");
	//Thread.sleep(1000);
	driver.findElement(By.id("name")).sendKeys("Uma Kesariya");
	driver.findElement(By.id("email")).sendKeys("r.rani468@gmail.com");
	driver.findElement(By.id("container_4_4")).sendKeys("8792604219");
	driver.findElement(By.xpath("//div[@id='wrapper']/descendant::input[@type='submit']")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("message-placeholder")).sendKeys("what is today gold prize");
	//List<WebElement> chatsMsgs = driver.findElements(By.xpath("//div[@id='view-chat']/p/span"));
	
	}
}
