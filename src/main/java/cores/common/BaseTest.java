package cores.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class BaseTest {
    WebDriver driver;
    public WebDriver getBrowserDriver(String browserName) {
        browserList1 browserList = browserList1.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case CHROME:
                driver = WebDriverManager.chromedriver().create();
//                WebDriverManager.chromedriver().browserVersion("101.0.4951.67").setup();
                break;
            case FIREFOX:
                driver =  WebDriverManager.firefoxdriver().create();
                break;
            case EDGE:
                driver = WebDriverManager.edgedriver().create();
                break;
            default:
                throw new RuntimeException("Browser name is not  valid");
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
    protected int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(999999);
    }
}
