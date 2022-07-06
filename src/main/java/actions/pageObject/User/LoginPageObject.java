package actions.pageObject.User;

import interfaces.pageUIs.User.LoginPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject extends cores.common.BasePage_Executor{
    WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        this.driver =driver;
    }
    public void inputToEmailAddressTextBox(String emailAddress) {
        sendKeyToElement(driver,LoginPageUI.EMAIL_ADDRESS_TEXTBOX,emailAddress);
    }

    public void inputToPasswordTextBox(String password) {
        sendKeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON).click();
    }

    public String getEmailAddressEmptyErrorMessage() {
        return waitForElementVisible(driver,LoginPageUI.EMAIL_ADDRESS_EMPTY_ERROR_MESSAGE).getText();
    }

    public String getPasswordEmptyErrorMessage() {
        return waitForElementVisible(driver,LoginPageUI.PASSWORD_ERROR_MESSAGE).getText();

    }

    public String getEmailAddressInvalidErrorMessage() {
       return waitForElementVisible(driver,LoginPageUI.EMAIL_ADDRESS_INVALID_ERROR_MESSAGE).getText();
    }

    public String emailPasswordIncorrectErrorMessage() {
        return waitForElementVisible(driver,LoginPageUI.EMAIL_PASSWORD_INCORRECT_ERROR_MESSAGE).getText();
    }

    public String passwordINValidErrorMessage() {
        return waitForElementVisible(driver,LoginPageUI.PASSWORD_INVALID_ERROR_MESSAGE).getText();
    }

}
