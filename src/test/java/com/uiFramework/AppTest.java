package com.uiFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AppTest {
	
	private WebDriver driver;
	/*public AppTest(WebDriver driver) {
		this.driver=driver;
	}*/
	
	
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\msharma13\\eclipse-workspace\\uiFramework\\src\\main\\resources\\driver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://intranet.xavient.com/xap/");
	  driver.manage().timeouts().implicitlyWait(101, TimeUnit.SECONDS);
	  driver.manage().timeouts().pageLoadTimeout(101, TimeUnit.SECONDS);
	  //driver.manage().window().maximize();
	  driver.findElement(By.id("txtLoginName")).sendKeys("msharma13");
	  driver.findElement(By.id("btnLogin")).click();
  }
}
