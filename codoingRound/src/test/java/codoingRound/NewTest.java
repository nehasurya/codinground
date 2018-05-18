package codoingRound;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	
	WebDriver driver;

    @FindBy(xpath ="//*[@title='Find hotels in destinations around the world']")
    static WebElement hotelLink;
    
   
    
    @FindBy(id = "Tags")
    static WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    static WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    static WebElement travellerSelection;
  
 
    
    @Test
    public void shouldBeAbleToSearchForHotels() {
        setDriverPath();
        driver = new ChromeDriver();
        driver.get("https://www.cleartrip.com/");
     
       //  driver.findElement(By.xpath("//*[@class='hotelApp ']")).click();
       PageFactory.initElements(driver,NewTest.class );
       
       hotelLink.click();

        localityTextBox.sendKeys("Indiranagar, Bangalore");

        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        searchButton.click();

        driver.quit();

    }

    private void setDriverPath() {
       
            System.setProperty("webdriver.chrome.driver", "‪‪‪‪C:\\Users\\nsury_000\\Downloads\\chromedriver.exe");
        
    }

}
