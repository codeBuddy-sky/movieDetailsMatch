package com.project.IMBD;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IMDB_Search  {

	public static WebDriver driver;
	
	static String imdbReleaseDAte;
	static String imdbCountryOrigin;

	@BeforeTest
	public void launchIMDB() {

		// WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");

		driver = new ChromeDriver();

		// Launch applicaiton and print all tags (links) in login page.
		driver.get("https://www.imdb.com/");
		driver.manage().window().maximize();

		//Find SearchBox
		WebElement searchBox = driver.findElement(By.name("q"));
		
		//Enter the value in search box
		searchBox.sendKeys("Pushpa: The Rise");

		//Click on search button
		driver.findElement(By.id("iconContext-magnify")).click();
		
		//Click on the search list -- Pushpa: The Rise 1
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/table/tbody/tr[1]/td[2]/a")).click();
		
        // Scrolling down the page till the element is found	
		JavascriptExecutor js = (JavascriptExecutor) driver;       		
        WebElement Element = driver.findElement(By.xpath("//span[text()='Details']"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        
        //Release Date
        WebElement releaseDate = driver.findElement(By.xpath("(//li[@data-testid='title-details-releasedate']//a)[2]"));
         imdbReleaseDAte = releaseDate.getText();
         System.out.println(imdbReleaseDAte);
        
        //Country of origin
        WebElement countryOrigin = driver.findElement(By.xpath("//li[@data-testid='title-details-origin']//div//ul//li//a"));
         imdbCountryOrigin = countryOrigin.getText();
         System.out.println(imdbCountryOrigin);
     
        

	}

	@AfterClass
	public void burnDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}

}