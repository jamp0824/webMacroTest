package com.study.webpack;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

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
	private String test_url;
	
	public SeleniumTest() {
		super();
		
		//System Property SetUp
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\loney\\Downloads\\1\\chromedriver.exe");
		//버전 97.0.4692.99
		//Driver SetUp
		
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		
//		options.addArguments("--headless", "--disable-gpu","-no-sandbox");
//		options.addArguments("window-size=1920x1080");
//		options.addArguments("user-agent= Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.82 Safari/537.36");
//		options.addArguments("lang=ko_KR");
		
		driver = new ChromeDriver(options);
		base_url = "https://smartstore.naver.com/nosiboo/products/4152944658#scrollY=29212.80078125"; 
		test_url = "https://smartstore.naver.com/nosiboo/products/5136127592";
	}
	
	/**
	 * 
	 */
	public void crawl() {
		try {
			//get page
			driver.get("https://naver.com");
			
			//naver로그인 
			driver.findElement(By.xpath("//*[@class=\"link_login\"]")).click();

			String userId = ""; 
			StringSelection stringSelection1 = new StringSelection(userId);
			Clipboard clipboard1 = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard1.setContents(stringSelection1, null);
			driver.findElement(By.id("id")).sendKeys(Keys.SHIFT,Keys.INSERT); 
			
			
			String userPasswd = ""; 
			StringSelection stringSelection2 = new StringSelection(userPasswd);
			Clipboard clipboard2 = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard2.setContents(stringSelection2, null);
			driver.findElement(By.id("pw")).sendKeys(Keys.SHIFT,Keys.INSERT); 

			driver.findElement(By.xpath("//*[@id=\"log.login\"]")).click();
			
			String phoneNum = "01099681733";
			if(driver.findElement(By.id("phone_value")).isDisplayed()) {
			driver.findElement(By.id("phone_value")).sendKeys(phoneNum); 
			driver.findElement(By.xpath("//*[@id=\"oab.submit\"]")).click();
			}
			driver.get(base_url);
//			driver.get(test_url);
//			System.out.println(driver.getPageSource());
			 boolean displayed = false;
			 String buyButton = "//*[@class=\"OgETmrvExa N=a:pcs.buy\"]/a[1]";
			    List<WebElement> element = driver.findElements(By.xpath(buyButton));
//			   
//			    driver.findElement(By.xpath("//*[@class=\"bd_3hLoi\"]/a[1]")).click();
//			    System.out.println("12312321322222222222"+driver.findElement(By.xpath("//*[@class=\"bd_zxkRR\"]/li[1]")).getText());
//			    driver.findElement(By.xpath("//*[@class=\"bd_zxkRR\"]/li[1]")).click();
			   //10분 간 refresh용 
			    int refreshCount = 20000;
			    System.out.println("element.size()"+element.size());
			    for (int i = 0; i < refreshCount; i++) {    
			        if (element.size() > 0) {     
			            // Do the operation here on the element
			        	System.out.println("111111111111111");
						driver.findElement(By.xpath("//*[@class=\"bd_3hLoi\"]/a[1]")).click();
					    driver.findElement(By.xpath("//*[@class=\"bd_zxkRR\"]/li[1]/a[1]")).click();			
						driver.findElement(By.xpath(buyButton)).click();
						i=20000;
			        } else {  
			        	System.out.println("222222222222222");
			            driver.navigate().refresh();    
			        }     
			    }
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@class=\"btn_payment _click(nmp.front.order.order_sheet.account()) _stopDefault _doPayButton\"]")).click();
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//driver.close();
		}
	}
}
