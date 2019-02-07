package org.generics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public  WebElement  getWebElement(String locators,String value,WebDriver driver)
	{
		WebElement webEle=null;
		By by = null;
		if(locators.equals("id"))
		{
			webEle=driver.findElement(by.id(value));
		}
		else if (locators.equals("className"))
		{
			webEle=driver.findElement(By.className(value));
		}
		else if (locators.equals("cssSelector"))
		{
			webEle=driver.findElement(By.cssSelector(value));
		}
		else if(locators.equals("linkText"))
		{
			webEle=driver.findElement(By.linkText(value));
		}
		else if(locators.equals(""))
		{
			webEle=driver.findElement(By.name(value));
		}
		else if(locators.equals("partialLinkText"))
		{
			webEle=driver.findElement(By.partialLinkText(value));
		}
		else if(locators.equals("xpath"))
		{
			webEle=driver.findElement(By.xpath(value));
		}
		else
		{
			System.out.println("pleaseenter the correct locators");
		}
		return webEle;
	}

}
