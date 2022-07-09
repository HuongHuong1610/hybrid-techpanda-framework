package actions.pageObject.User;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

    public static HomePageObject getHomePage(WebDriver driver){
        return new HomePageObject(driver);
    }
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }
    public static MyDashBoardPageObject getMyDashBoard(WebDriver driver){
        return new MyDashBoardPageObject(driver);
    }
}
