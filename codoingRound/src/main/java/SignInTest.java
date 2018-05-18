import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest {

    public static WebDriver driver ;

    @Test(priority=1)
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
    	setDriverPath();
    	driver = new ChromeDriver();
        
                
        driver.get("https://www.cleartrip.com/");
        waitFor(5000);

        driver.findElement(By.linkText("Your trips")).click();
        driver.findElement(By.id("SignIn")).click();
        waitFor(3000);
       // WebElement ele=driver.findElement(By.xpath("//iframe[@id='modal_window']"));
        
        driver.switchTo().frame("modal_window");
        driver.findElement(By.xpath("//*[@id='signInButton']")).click();

        String errors1 = driver.findElement(By.id("errors1")).getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        driver.quit();
    }

    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void setDriverPath() {
    	/*System.out.println("isMac-"+PlatformUtil.isMac()+", isWindows-"+PlatformUtil.isWindows()+", isLinux-"+PlatformUtil.isLinux());
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }*/
    	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    	
    }


}
