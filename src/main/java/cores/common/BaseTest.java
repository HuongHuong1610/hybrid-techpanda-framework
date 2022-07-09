package cores.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class BaseTest {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    public WebDriver getBrowserDriver(String browserName) {
        browserList1 browserList = browserList1.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case CHROME:
                // Later browser driver version ( 101)
                driver = WebDriverManager.chromedriver().create();
//              System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
                // Specific browser Driver version 99 ~ browser version 99
//                WebDriverManager.chromedriver().driverVersion("99.0.4844.35").setup();

                // Base on : Browser Version ( setting trinh duyet chrome)
//                WebDriverManager.chromedriver().browserVersion("101.0.4951.67").setup();
                break;
            case FIREFOX:
                driver =  WebDriverManager.firefoxdriver().create();
//                System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");break;
            case EDGE:
                driver = WebDriverManager.edgedriver().create();
//                System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
                break;
            default:
                throw new RuntimeException("Browser name is not  valid");
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }
}
