package Fin_Test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;
import org.junit.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fin_Class {
	
	   static WebDriver driver; 
	    
	    @BeforeClass public static void BrowserOpen() {
	    	
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe ");
		driver= new ChromeDriver() ;  }
	    
	    @Test 
	    public void Register_User() {
	    	
	    driver.get("https://www.finartz.com/");
	    Assert.assertTrue(driver.getTitle().equals("Finartz - Homepage"));
	    System.out.println("Web Sitesi Açıldı");
	  
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    
	    //WebElement homepageLink = driver.findElement(By.linkText("Solutions"));
	    //homepageLink.click();
	    driver.get("https://www.finartz.com/solutions.html");
	    Assert.assertTrue(driver.getTitle().equals("Solutions - Finartz"));
		System.out.println("Solutions Sayfası Açıldı");
	    
		List<WebElement> rows = driver.findElements(By.className("title"));
		System.out.println("Seçilen toplam satýr: " + rows.size());
		
                 //iterator, listelerden geçiþ yapmasını saglayan bir nesnedir   
		//ıterator kullanarak tüm unsurları yineleyecegiz 
		Iterator<WebElement> iter = rows.iterator();
               //Bu listenin bir elemaný olup olmadıgını kontrol eder
			while (iter.hasNext())  {

				// Birer birer yinelenir
				WebElement item = iter.next();

				// metni al
				String label = item.getText();

				//metni yazdýr
				System.out.println(label);}
			
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
			
			
		driver.get("http://medium.com/finartz");
		Assert.assertTrue(driver.getTitle().equals("Finartz"));
		System.out.println("Medium Sayfasý Açýldý");
		
		WebElement login=driver.findElement(By.className("js-predictiveSearchInput"));
		login.sendKeys("Kamu Hizmetleri");
		driver.findElement(By.className("browser-chrome")).click();
		
		driver.close();
		System.out.println("Tarayıcı başarıyla kapatıldı");
		
			}
	    
	    }
