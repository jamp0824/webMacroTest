package com.study.webpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {

	public static void main(String[] args) {
		
		SeleniumTest selTest = new SeleniumTest();
		selTest.crawl();
		
	}
	
	//WebDriver
	private WebDriver driver;
	
	private WebElement webElement;
	//properties
	
   // public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	//public static final String WEB_DRIVER_PATH = "C:/Users/loney/Downloads/chromedriver_win32/chromedriver.exe";
	
	//크롤링 할 url
	private String base_url;
	
	public SeleniumTest() {
		super();
		
		//System Property SetUp
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\loney\\Downloads\\1\\chromedriver.exe");
		//버전 97.0.4692.99
		//Driver SetUp
		
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		
		driver = new ChromeDriver(options);
		base_url = "https://smartstore.naver.com/nosiboo/products/5136127592"; 
	}
	
	public void crawl() {
		try {
			//get page
			driver.get("https://naver.com");
			Thread.sleep(2000);
			
			//naver로그인 
			driver.findElement(By.xpath("//*[@class=\"link_login\"]")).click();
			Thread.sleep(2000);

			String user_id = "test"; 
			String user_passwd = "test"; 
			driver.findElement(By.id("id")).sendKeys(user_id); 
			driver.findElement(By.id("pw")).sendKeys(user_passwd);

			driver.findElement(By.xpath("//*[@id=\"log.login\"]")).click();

//			driver.get(base_url);
//			
//			System.out.println(driver.getPageSource());
//			
//			driver.findElement(By.xpath("//*[@class=\"bd_3hLoi\"]/a[1]")).click(); 
//			driver.findElement(By.xpath("//*[@class=\"bd_1y1pd\"]/a[1]")).click(); 
//			driver.findElement(By.xpath("//*[@class=\"OgETmrvExa N=a:pcs.buy\"]/a[1]")).click(); 
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//driver.close();
		}
	}
}
