package Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondTest {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AJ\\Desktop\\PST\\chromedriver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/");
		driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][4]")).click();
		WebElement webElement = driver.findElement(By.xpath("//div[@class='element-group'][4]//li[@id='item-4']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
		
		driver.findElement(By.xpath("//button[@id='startStopButton']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-valuenow='100']")));
		driver.findElement(By.xpath("//button[@id='resetButton']")).click();
		
		//driver.close();
	}
}
