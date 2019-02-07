package org.slider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SlideDemo1 {
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
	WebElement slider = driver.findElement(By.id("slider"));
	Dimension sliderLocation = slider.getSize();
	int width = sliderLocation.getWidth();
	int x = slider.getLocation().getX();
	int y = slider.getLocation().getX();
	
	Actions action=new Actions(driver);

	for(int i=0;i<4;i++)	
	{
		Thread.sleep(500);

		action.clickAndHold(slider);
		action.moveByOffset(x, 0).build().perform();
		x=x+width;
	}
	for(int i=4;i>=0;i--)
	{
		Thread.sleep(500);
		action.clickAndHold(slider);
		action.moveByOffset(-y, 0).build().perform();
		y=y+width;
	}
	
	//376 571
	}

}
