package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SongsPage extends BasePage{
    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    private By pressButtonPlayOrResume = By.cssSelector("[title='Play or resume']");

    public void pressOnPlayBtn() {
        WebElement buttonPlayOrResume = wait.until(ExpectedConditions.presenceOfElementLocated(pressButtonPlayOrResume));
                //driver.findElement(By.cssSelector("[title='Play or resume']"));
        new Actions(driver)
                .moveToElement(buttonPlayOrResume)
                .perform();
        buttonPlayOrResume.click();
    }
}
