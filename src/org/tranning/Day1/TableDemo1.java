package org.tranning.Day1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TableDemo1 {

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
		driver.get("file:///Users/vineet/Desktop/Selenium/Table1.html");
		List<WebElement> pNames = driver.findElements(By.xpath("//tr/td[.='Whale']/parent::tr/td[1]"));
		System.out.println("Person working in project whale is :-"+pNames.size());
		for(WebElement name:pNames)
		{
			String text = name.getText();
			System.out.println(text);
		}
		
		
		String xp="//tr/td[.='Whale']/../td[.='Girish']/following-sibling::td[2]";
		List<WebElement> pTimeByGiri = driver.findElements(By.xpath(xp));
		System.out.println("time spend by girish on project whale");
		for(WebElement time:pTimeByGiri)
		{
			String timeText = time.getText();
			System.out.println(timeText);
		}
		
		String xp2="//tr/td[.='Girish']/../td[2]";
		
		List<WebElement> allProjectName = driver.findElements(By.xpath(xp2));
		System.out.println("projects worked by girish:-");
		for(WebElement pName:allProjectName)
		{
			System.out.println(pName.getText());
		}
		HashSet<String>uniqName=new HashSet<>();
		String xp3 = "//tr/td[1]";
		List<WebElement> allNames = driver.findElements(By.xpath(xp3));
		for(WebElement names:allNames)
		{
			String namesText = names.getText();
			uniqName.add(namesText);
		}
		System.out.println("all Unique names are");
		for(String name:uniqName) {
			System.out.println(name);
		}
		String xp4 = "//*[.='Girish']/../td[3]";
		List<WebElement> times = driver.findElements(By.xpath(xp4));
		double pTimes=0;
		for(WebElement time:times)
		{
			String text=time.getText();
			double num=Double.parseDouble(text);
			System.out.println("num"+num);
			pTimes=pTimes+num;
		}
		System.out.println("Total time spends by Girsh on all Project");
		System.out.println(pTimes);
		driver.close();
	}
}
