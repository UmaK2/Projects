package org.tranning.Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Gmail {

	
		// TODO Auto-generated method stub
		static
		{
			
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

		}

		public static void main(String[] args) throws InterruptedException 
		{
			// TODO Auto-generated method stub
			WebDriver driver=new ChromeDriver();
			driver.manage().window().fullscreen();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://accounts.google.com/");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys("r.rani468@gmail.com");
			//Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='identifierNext']/content/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Vineet@7799");
			driver.findElement(By.xpath("//div[@id='passwordNext']/content/span")).click();
			driver.findElement(By.xpath("//div[@class='gb_9 gb_vd gb_R gb_ag']/div/a")).click();
			driver.findElement(By.xpath("//a[@id='gb23']")).click();
			WebElement primaryElement = driver.findElement(By.className("aKz"));
			String color = primaryElement.getCssValue("color");
			System.out.println("color is--"+color);
			if(color.equals("rgba(217, 48, 37, 1)"))
			{
				System.out.println("in primary");
				String str = driver.findElement(By.xpath("//div[@class='J-J5-Ji amH J-JN-I']/span/span[@class='ts']")).getText();
				System.out.println("in text"+str);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//tr[@id=':2u']/descendant::td[@class='yX xY ']")).click();
				Thread.sleep(2000);
				driver.findElement(By.id(":oi")).click();
			}
			else 
			{
				driver.findElement(By.className("aKz")).click();
			}
			
			//driver.close();
	}

}
