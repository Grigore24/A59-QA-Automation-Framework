package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By avatar = By.cssSelector("img[class='avatar']");
    public boolean getAvatar(){
        return driver.findElement(avatar).isDisplayed();
    }
//    public WebElement getUserAvatar(){
//        return findElement(userAvatarIcon);
//    }
}