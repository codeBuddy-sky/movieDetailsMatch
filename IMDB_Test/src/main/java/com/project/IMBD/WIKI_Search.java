package com.project.IMBD;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class WIKI_Search extends IMDB_Search{
	
	static String wikiReleaseDate;
	static String wikiCountryOrigin;
	
	public static WebDriver driver;
	
	@BeforeTest
	public void launchWiki() throws InterruptedException {
		// WebDriverManager.chromedriver().setup();
		Thread.sleep(10000);
				System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");

				driver = new ChromeDriver();

				// Launch applicaiton and print all tags (links) in login page.
				driver.get("https://www.wikipedia.org/");

				driver.manage().window().maximize();
//			}
//	
//	@Test(priority = 2)
//	public void searchWIKI() {
		
		//Find SearchBox
				WebElement searchBox = driver.findElement(By.id("searchInput"));
				//Enter the value in search box
				searchBox.sendKeys("Pushpa: The Rise");
				//Click on search button
				driver.findElement(By.xpath("//*[@id=\"search-form\"]/fieldset/button/i")).click();
				
		        // Scrolling down the page till the release date is found	
				JavascriptExecutor js = (JavascriptExecutor) driver;       		
		        WebElement releaseTag = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[12]/th/div"));
		        js.executeScript("arguments[0].scrollIntoView();", releaseTag);
		        
		        //Release Date
		        WebElement WIKIreleaseDate = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[12]/td/div"));
		         wikiReleaseDate = WIKIreleaseDate.getText();
		         System.out.println(wikiReleaseDate);
		        //Country of origin
		        WebElement WIKIcountryOrigin = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[14]/td"));
		         wikiCountryOrigin = WIKIcountryOrigin.getText();
		         System.out.println(wikiCountryOrigin);
		
	}
	
	@AfterClass
	public void exit() {
		driver.quit();
	}

	}