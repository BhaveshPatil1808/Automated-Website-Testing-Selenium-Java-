package project;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sauslab {
	
	@Test
	public  void main() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("profile.credentials_enable_service", false);
        options.setExperimentalOption("prefs", prefs);

        WebDriverManager.chromedriver().setup();
		
        
        
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(1000);
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(1000);
		
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Fleece Jacket']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='add-to-cart']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("first-name")).sendKeys("Virat");
		Thread.sleep(1000);
		driver.findElement(By.id("last-name")).sendKeys("Kholi");
		Thread.sleep(1000);
		
		driver.findElement(By.id("postal-code")).sendKeys("400001");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("finish")).click();
		
		Thread.sleep(1000);
		
		String actualTitle = driver.findElement(By.className("complete-header")).getText();
		System.out.println(actualTitle);
		String expectedTitle="Thank you for your order!";
		Assert.assertEquals(actualTitle, expectedTitle);
		
		Thread.sleep(1000);
		driver.close();
		
	}

}
