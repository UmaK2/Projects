package org.tranning.senario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BlueStone {
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
		driver.get("https://www.bluestone.com/");
		WebElement webEleRings = driver.findElement(By.xpath("//li[@class='menuparent repb']/a[@title='Rings']"));
		Actions action=new Actions(driver);
		action.moveToElement(webEleRings).perform();
		Thread.sleep(500);
		String xp="//div[@class='wh-submenu medium-width']/ul/li/div[@class='col-inner']/ul/descendant::li/a[contains(.,'Diamond Rings')]";
		 driver.findElement(By.xpath(xp)).click();
		 String xp1="//div[@id='product-display']/descendant::span[@class='p-wrap']/span/span/span[@class='new-price']";
		 List<WebElement> allPrice = driver.findElements(By.xpath(xp1));
		 int size=allPrice.size();
		 System.out.println("size"+size);
		 ArrayList<String>al=new ArrayList<>();
		 for(int i=0;i<size;i++)
		 {
			 String text = allPrice.get(i).getText();
			 String rupees=text.replaceAll("RS.", "");
			 System.out.println("price is---"+rupees);
			 //int i=0;
			 Thread.sleep(1000);
			 writeOnExcel("./Data/input.xls","Sheet1",i,0,rupees);
			 al.add(rupees);
		 }
		// System.out.println(al);
		 //Thread.sleep(1000);
		 WebElement element = driver.findElement(By.xpath("//section[@class='block sort-by pull-right']"));
		 
		 action.moveToElement(element).perform();
		 driver.findElement(By.xpath("//div[@id='view-sort-by']/div/a[.='Price Low to High ']")).click();
		 Thread.sleep(1000);
		// string xp2="//div[@id='product-display']/descendant::span[@class='p-wrap']/span/span/span[@class='new-price']";
		//System.out.println("web element"+ele.getText());
		 
		 String xp2="//div[@id='product-display']/descendant::span[@class='p-wrap']/span/span/span[@class='new-price']";
		 List<WebElement> allPricesort = driver.findElements(By.xpath(xp2));
		 ArrayList<String>al2=new ArrayList<>();
		 for(int j=0;j<allPricesort.size();j++)
		 {
			 String text1 = allPricesort.get(j).getText();
			 String sortedRupees=text1.replaceAll("RS.", "");
			 System.out.println("price is---"+sortedRupees);
			 al2.add(sortedRupees);
			 writeOnExcel("./Data/input.xls","Sheet1",j,1,sortedRupees);

		 }
		 if(al.equals(al2))
		 {
			 System.out.println("both list are equals");
		 }
		 else
		 {
			 System.out.println("not equlas");
		 }
		 
		 readOnExcel("./Data/input.xls","Sheet1",0);
		// System.out.println(al2);
		 driver.close();
	}
	
	public static void writeOnExcel(String path,String sheet,int row,int cell,String data) 
	{
		FileInputStream fis;
		try {
			fis = new FileInputStream(path);
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sh = workbook.getSheet(sheet);
			Row rowCount = sh.createRow(row);
			Cell cellCount = rowCount.createCell(cell);
			cellCount.setCellValue(data);
			FileOutputStream fos=new FileOutputStream(path);
			workbook.write(fos);
			fos.close();
			
			
			
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readOnExcel(String path,String sheet,int row) {
		FileInputStream fis;
		String[][]array;
		try {
			fis = new FileInputStream(path);
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sh = workbook.getSheet(sheet);
			array=new String[sh.getPhysicalNumberOfRows()][sh.getRow(row).getLastCellNum()];
			for(int i=0;i<sh.getPhysicalNumberOfRows();i++)
			{
				for(int j=0;j<sh.getRow(i).getLastCellNum();j++)
				{
					array[i][j]=sh.getRow(i).getCell(j).toString();
				}
				
			}
			System.out.println("array is"+array);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
