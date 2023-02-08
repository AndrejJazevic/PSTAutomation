package Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FourthTest {
	
	ChromeDriver driver = null;
	String email = "test111.testas@gmail.com";
	
	@BeforeClass
	public static void BeforeClass()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AJ\\Desktop\\PST\\chromedriver\\chromedriver.exe");
	}
	
	@Before
	public void Before()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
	}
	
	@Test
	public void test01()
	{
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.xpath("//input[@id='gender-male']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Testas");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Test1234");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("Test1234");
		driver.findElement(By.xpath("//input[@id='register-button']")).click();
		driver.findElement(By.xpath("//input[@class='button-1 register-continue-button']")).click();
	}
	
	@Test
	public void test02() throws InterruptedException, IOException
	{
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Test1234");
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		driver.findElement(By.xpath("//div[@class='listbox']//a[@href='/digital-downloads']")).click();
		
		File file1 = new File("C:\\Users\\AJ\\Desktop\\PST\\Lab 1\\data1.txt");
		Scanner input1 = new Scanner(file1);
		while(input1.hasNextLine())
		{
			String str = input1.nextLine();
			driver.findElement(By.xpath("//div[@class='details']//a[text()='"+str+"']/following::input[@value='Add to cart']")).click();
			TimeUnit.SECONDS.sleep(2);
		}
		input1.close();
		
		
		driver.findElement(By.xpath("//div[@class='header-links-wrapper']//a[@href='/cart']//span[@class='cart-label']")).click();
		driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		
		driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']")).click();
		driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']//option[@value='156']")).click();
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("Vilnius");
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("Vilniaus rajonas");
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("Lt-00000");
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("+37012345678");
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		TimeUnit.SECONDS.sleep(2);
		driver.findElement(By.xpath("//div[@id='payment-method-buttons-container']//input[@value='Continue']")).click();
		TimeUnit.SECONDS.sleep(2);
		driver.findElement(By.xpath("//div[@id='payment-info-buttons-container']//input[@value='Continue']")).click();
		TimeUnit.SECONDS.sleep(2);
		driver.findElement(By.xpath("//div[@id='confirm-order-buttons-container']//input[@value='Confirm']")).click();
		TimeUnit.SECONDS.sleep(2);
	}
	
	@Test
	public void test03() throws InterruptedException, IOException
	{
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Test1234");
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		driver.findElement(By.xpath("//div[@class='listbox']//a[@href='/digital-downloads']")).click();
		
		File file2 = new File("C:\\Users\\AJ\\Desktop\\PST\\Lab 1\\data2.txt");
		Scanner input2 = new Scanner(file2);
		while(input2.hasNextLine())
		{
			String str = input2.nextLine();
			driver.findElement(By.xpath("//div[@class='details']//a[text()='"+str+"']/following::input[@value='Add to cart']")).click();
			TimeUnit.SECONDS.sleep(2);
		}
		input2.close();
		
		
		driver.findElement(By.xpath("//div[@class='header-links-wrapper']//a[@href='/cart']//span[@class='cart-label']")).click();
		driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		TimeUnit.SECONDS.sleep(2);
		driver.findElement(By.xpath("//div[@id='payment-method-buttons-container']//input[@value='Continue']")).click();
		TimeUnit.SECONDS.sleep(2);
		driver.findElement(By.xpath("//div[@id='payment-info-buttons-container']//input[@value='Continue']")).click();
		TimeUnit.SECONDS.sleep(2);
		driver.findElement(By.xpath("//div[@id='confirm-order-buttons-container']//input[@value='Confirm']")).click();
		TimeUnit.SECONDS.sleep(2);
	}
	
	@After
	public void After()
	{
		driver.close();
	}
	
	@AfterClass
	public static void AfterClass()
	{
		System.out.println("AfterClass");
	}
}