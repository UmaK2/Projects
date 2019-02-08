package org.slider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SlideDemo2 {
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
		driver.get("https://jqueryui.com/slider/");
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/span"));
		Actions action=new Actions(driver);

		for(int i=0;i<100;i+=10)
		{	Thread.sleep(500);
			action.clickAndHold(slider).moveByOffset(i, 0).perform();;
		}
		for(int i=100;i>0;i-=10)
		{	Thread.sleep(500);
			action.clickAndHold(slider).moveByOffset(-i, 0).perform();;
		}
	}

}
