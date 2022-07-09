package actions.pageObject.User;

import interfaces.pageUIs.User.HomePageUI;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends cores.common.BasePage_Executor {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToMyAccountLink() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK).click();
    }
}
