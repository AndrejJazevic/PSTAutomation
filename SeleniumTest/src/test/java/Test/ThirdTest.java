package Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class ThirdTest {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AJ\\Desktop\\PST\\chromedriver\\chromedriver.exe");
		final ChromeDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.withTimeout(Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(2000));
		wait.ignoring(NoSuchElementException.class);
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/");
		driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][1]")).click();
		driver.findElement(By.xpath("//div[@class='element-group'][1]//li[@id='item-3']")).click();
		
		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>()
		{
			public Boolean apply(WebDriver arg0)
			{
				WebElement we1 = arg0.findElement(By.xpath("//div[@class='-center']//span[@class='-totalPages']"));
				String textValue = we1.getText();
				System.out.print(textValue);
				if(textValue.equals("2"))
				{
					return true;
				}
				driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).click();
				driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("test");
				driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("test");
				driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("test@gmail.com");
				driver.findElement(By.xpath("//input[@id='age']")).sendKeys("30");
				driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("500");
				driver.findElement(By.xpath("//input[@id='department']")).sendKeys("test");
				driver.findElement(By.xpath("//button[@id='submit']")).click();
				return false;
			}
		};
		wait.until(function);
		
		TimeUnit.SECONDS.sleep(1);
		WebElement webElement = driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']//div[@class='web-tables-wrapper']//div[@class='pagination-bottom']//button[text()='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.xpath("//div[@class='rt-tr-group'][1]//div[@class='rt-td'][7]//span[@id='delete-record-11']")).click();
		
		//driver.close();
	}
}
