package actions.pageObject.User;

import interfaces.pageUIs.User.HomePageUI;
import interfaces.pageUIs.User.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends cores.common.BasePage_Executor {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPageObject clickToMyAccountLink() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        getWebElement(driver,HomePageUI.MY_ACCOUNT_LINK).click();
        return PageGeneratorManager.getLoginPage(driver);
    }
}
