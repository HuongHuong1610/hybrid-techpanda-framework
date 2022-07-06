package cores.common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class BasePage_Teacher {
    /* Web browser*/
    // Note:
    //1 . Tham so bat buoc cua 1 ham tuong tac voi Web Browser la Webdriver

    /**
     * Open any page Url
     *
     * @param pageURL
     * @author huong.vt
     */
    public void openPageUrl(WebDriver driver,String pageURL) {
        driver.get(pageURL);
    }
    /**
     * get Page Url
     * @param driver
     */
    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }
    /**
     * get page title
     * @param driver
      */
    public String  getPageTitle(WebDriver driver){
        return driver.getTitle();
    }
    /**
     * get page Source Code
     * @param driver
     */
    public String getPageSourceCode(WebDriver driver){
        return driver.getPageSource();
    }
    /**
     * back to previous page , forward , refresh
     * @param driver
     */
    public void backToPage(WebDriver driver){
        driver.navigate().back();
    }
    public void forwardToPage(WebDriver driver){
        driver.navigate().forward();
    }
    public void refresherToPage(WebDriver driver){
        driver.navigate().refresh();
    }
    public void acceptAlert(WebDriver driver){
        driver.switchTo().alert().accept();
    }
    public void cancelAlert(WebDriver driver){
        driver.switchTo().alert().dismiss();
    }
    public void SenkeyAlert(WebDriver driver,String valueToSendKey){
        driver.switchTo().alert().sendKeys(valueToSendKey);
    }
    public String getAlertText(WebDriver driver){
        return  driver.switchTo().alert().getText();
    }
    /**
     * Switch to Window by ID
     * @param driver
     * @param expectedID
     */
    public void switchToWindowByID(WebDriver driver, String expectedID){
        Set<String> listAllTabs = driver.getWindowHandles();
        for (String id:listAllTabs
             ) {
            if(!id.equals(expectedID)){
                driver.switchTo().window(id);
            }

        }
    }
    /**
     * Switch to Window by Title
     *@param driver
     *@param expectedTitle
     */
    public void switchToWindowByTitle(WebDriver driver , String expectedTitle){
        Set<String> listAllTabs = driver.getWindowHandles();
        for (String id:listAllTabs
             ) {
            driver.switchTo().window(id);
            if(driver.getTitle().equals(expectedTitle)){
                break;
            }
        }
    }
    /* Web Element*/
    // Note:
    //1 . Tham so bat buoc cua 1 ham tuong tac voi Web Element la String locator
    //2. Nhung step nao co dung lai element > 2 lan tro len --> Khai bao bien local

    public WebElement getWebElement(WebDriver driver , String locator){
        return driver.findElement(getByXpath(locator));
    }
    public  List<WebElement> getListElement(WebDriver driver , String locator){
        return driver.findElements(getByXpath(locator));
    }
    public By getByXpath(String locator){
        return By.xpath(locator);
    }
    public void clickToElement(WebDriver driver , String locator){
        getWebElement(driver,locator).click();
    }
    public void sendKeyToElement(WebDriver driver, String locator ,String valueToInput){
        WebElement element = getWebElement(driver,locator);
        element.clear();
        element.sendKeys(valueToInput);
    }

    public void selectItemInDefaultDropdown(WebDriver driver , String locator , String Itemtext){
        Select select = new Select(getWebElement(driver,locator));
        select.selectByVisibleText(Itemtext);
    }
    public String  getFirstSelectedTextItem(WebDriver driver , String locator){
        Select select = new Select(getWebElement(driver,locator));
        return select.getFirstSelectedOption().getText();
    }
public boolean isDropdownMultiple(WebDriver driver, String locator){
    Select select = new Select(getWebElement(driver,locator));
     return select.isMultiple();
}
public void selectItemInCustomDropdown(){

}
    public String getElementText(WebDriver driver , String locator){

        return getWebElement(driver,locator).getText();
    }
    public String getAttribute(WebDriver driver , String locator , String attribute){
        return getWebElement(driver,locator).getAttribute(attribute);
    }
    public String getCssValue(WebDriver driver , String locator , String cssValue){
        return getWebElement(driver,locator).getCssValue(cssValue);
    }
    public int getListElementSize(WebDriver driver , String locator){
       return getListElement(driver, locator).size();
    }
    public void checkToCheckboxOrRadioButton(WebDriver driver , String locator){
        if(!isElementIsSelected(driver,locator)){
            clickToElement(driver,locator);
        }
    }
    public void unCheckToCheckbox(WebDriver driver , String locator){
        if(isElementIsSelected(driver,locator)){
            clickToElement(driver,locator);
        }
    }
    public boolean isElementIsDisplayed(WebDriver driver , String locator){
        return getWebElement(driver,locator).isDisplayed();
    }
    public boolean isElementIsEnabled(WebDriver driver , String locator){
        return getWebElement(driver,locator).isEnabled();
    }
    public boolean isElementIsSelected(WebDriver driver , String locator){
        return getWebElement(driver,locator).isSelected();
    }
    public void switchToIframe(WebDriver driver , String locator){
        driver.switchTo().frame(getWebElement(driver,locator));
    }
    public void switchToDefaultContent(WebDriver driver){
        driver.switchTo().defaultContent();
    }
    public void hoverMouseToElement(WebDriver driver , String locator){
        Actions actions = new Actions(driver);
        actions.moveToElement(getWebElement(driver,locator)).perform();
    }
    public void rightClickToElement(WebDriver driver , String locator){
        Actions actions = new Actions(driver);
        actions.contextClick(getWebElement(driver,locator)).perform();
    }
    public void doubleClickToElement(WebDriver driver , String locator){
        Actions actions = new Actions(driver);
        actions.doubleClick(getWebElement(driver,locator)).perform();
    }
    public void dragAndDropToElement(WebDriver driver , String sourcelocator, String targetLocator){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(getWebElement(driver,sourcelocator),getWebElement(driver,targetLocator)).perform();
    }
    public void pressKeyToElement(WebDriver driver, String locator, Keys key){
        Actions actions = new Actions(driver);
        actions.sendKeys(getWebElement(driver,locator),key).perform();
    }
}
