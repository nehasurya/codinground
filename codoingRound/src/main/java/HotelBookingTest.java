import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest {

    WebDriver driver;

    @FindBy(xpath ="//*[@title='Find hotels in destinations around the world']")
    static WebElement hotelLink;
    
   
    
    @FindBy(id = "Tags")
    static WebElement localityTextBox;

    @FindBy(xpath = "//input[@class='booking ']")
    static WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    static WebElement travellerSelection;

    @Test
    public void shouldBeAbleToSearchForHotels() {
        setDriverPath();
        driver = new ChromeDriver();
        driver.get("https://www.cleartrip.com/");
       
        PageFactory.initElements(driver,HotelBookingTest.class);
         hotelLink.click();

        localityTextBox.sendKeys("Indiranagar, Bangalore");

        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        searchButton.click();

        driver.quit();

    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

}
