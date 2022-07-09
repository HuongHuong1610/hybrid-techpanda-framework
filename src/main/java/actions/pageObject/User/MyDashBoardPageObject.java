package actions.pageObject.User;

import interfaces.pageUIs.User.MyDashBoardPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyDashBoardPageObject extends cores.common.BasePage_Executor{
    WebDriver driver;
    public MyDashBoardPageObject(WebDriver driver) {
        this.driver =driver;
    }
    public WebElement getContactInformationByUserName() {
        return waitForElementVisible(driver, MyDashBoardPageUI.CONTACT_INFORMATION_BY_USERNAME);
    }

    public WebElement getContactInformationByEmail() {
        return waitForElementVisible(driver,MyDashBoardPageUI.CONTACT_INFORMATION_BY_EMAIL);
    }
}
