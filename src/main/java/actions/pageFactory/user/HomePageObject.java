package actions.pageFactory.user;

import interfaces.pageUIs.User.HomePageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageObject extends cores.common.BasePage_Factory_Teacher {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(how = How.XPATH,using = "//div[@class='footer']//a[@title='My Account']")
    WebElement myAccountLink;
    public void clickToMyAccountLink() {
        clickToElement(driver,myAccountLink);
    }
}