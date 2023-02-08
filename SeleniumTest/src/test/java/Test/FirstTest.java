package Test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
	
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AJ\\Desktop\\PST\\chromedriver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//driver.get("https://www.google.com");
		//driver.findElement(By.xpath("//div[text()='Priimti viską']")).click();
		//driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Test Automation");
		//driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//h3[text()='Test automation - Wikipedia']")).click();
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		
		driver.findElement(By.xpath("//input[@class='button-1 register-button']")).click();
		driver.findElement(By.xpath("//input[@id='gender-male']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Testas");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("test123.testas@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Test1234");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("Test1234");
		driver.findElement(By.xpath("//input[@id='register-button']")).click();
		driver.findElement(By.xpath("//input[@class='button-1 register-continue-button']")).click();
		
		//Log in
		//driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("test1.testas@gmail.com");
		//driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Test1234");
		//driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		
		driver.findElement(By.xpath("//div[@class='listbox']//a[@href='/computers']")).click();
		driver.findElement(By.xpath("//div[@class='listbox']//a[@href='/desktops']")).click();
		
		driver.findElement(By.xpath("//div[@class='add-info']//div[@class='prices']//span[text()>1500.00]/following::input[@value='Add to cart']")).click();
		TimeUnit.SECONDS.sleep(3);
		
		driver.findElement(By.xpath("//div[@class='center-2']//div[@class='overview']//div[@class='add-to-cart']//div[@class='add-to-cart-panel']//input[@value='Add to cart']")).click();
		TimeUnit.SECONDS.sleep(3);
		driver.get(driver.getCurrentUrl());
		TimeUnit.SECONDS.sleep(2);
		
		driver.findElement(By.xpath("//div[@class='header-links-wrapper']//a[@href='/cart']//span[@class='cart-label']")).click();
		driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
		driver.findElement(By.xpath("//input[@name='updatecart']")).click();
		TimeUnit.SECONDS.sleep(2);
		driver.get(driver.getCurrentUrl());
		
		//driver.close();
	}

}
