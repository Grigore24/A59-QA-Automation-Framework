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
    /////////////Locators Homework18 playsong //////////////
    private By pressButtonPlayOrResume = By.cssSelector("[title='Play or resume']");
    private By pauseBtnDisplayed = By.cssSelector("[data-testid='pause-btn']");
    ////////////Locators ActionsTests playSongFromListTest /////////////
    private By findAllSongsPage = By.cssSelector(".songs");
    private By pressRightClickOnFirstSong = By.cssSelector(".song-item");
    private By pressOnPlaySongBtn = By.cssSelector(".playback");
    private By checkIsEqualizerDisplayed = By.cssSelector("[data-testid='sound-bar-play']");
    //////////////Locators ActionTests countSongsInsidePlaylist //////////////
   // private By
    /////////////Methods Homework18 playsong //////////////
    public void pressOnPlayBtn() {
        WebElement buttonPlayOrResume = wait.until(ExpectedConditions.presenceOfElementLocated(pressButtonPlayOrResume));
                //driver.findElement(By.cssSelector("[title='Play or resume']"));
        new Actions(driver)
                .moveToElement(buttonPlayOrResume)
                .perform();
        buttonPlayOrResume.click();
    }
    public boolean isPauseBtnDisplayed() {
        return waitUntilPresense(pauseBtnDisplayed).isDisplayed();
        //driver.findElement(By.cssSelector("[data-testid='pause-btn']")).isDisplayed();
    }
    /////////////Methods Action tests playSongFromListTest ///////////
    public void goToAllSongs() {
        waitUntilClickable(findAllSongsPage).click();
    }
    public void rightClickOnFirstSong() {
        WebElement firstSong = waitUntilVisible(pressRightClickOnFirstSong);
        //driver.findElement(By.cssSelector(".song-item"));
        Actions actions = new Actions(driver);
        actions.contextClick(firstSong).perform();
    }
    public void clickPlayBtn() {
        WebElement playBtn = waitUntilClickable(pressOnPlaySongBtn);
        //driver.findElement(By.cssSelector(".playback"));
        playBtn.click();
    }
    public boolean isEqualizerDisplayed() {
        return waitUntilVisible(checkIsEqualizerDisplayed).isDisplayed();
        //driver.findElement(By.cssSelector("[data-testid='sound-bar-play']")).isDisplayed();
    }
    /////////Methods ActionTests countSongsInsidePlaylist///////////
}
