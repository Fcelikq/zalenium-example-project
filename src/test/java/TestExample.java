
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestExample {

    static RemoteWebDriver driver;
    static DesiredCapabilities desiredCapabilities;

    @BeforeClass
    public static void setupClass() throws MalformedURLException {
        desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
        desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);

        URL url = new URL("https://localhost:4444/wd/hub");
        driver = new RemoteWebDriver(url,desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.navigate().to("https://www.google.com");
    }

    @AfterClass()
    public void AfterClass() {
        driver.quit();
    }

    @Test
    public void test1(){
        driver.findElement(By.name("q")).sendKeys("selenium");
        driver.findElement(By.name("btnK")).click();
    }

}


