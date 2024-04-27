import POM.LoginPage;
import POM.SongsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
public class Homework18 extends BaseTest {
    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());
        loginPage.login("grigore.crepciuc@testpro.io", "te$t$tudent");
        songsPage.pressOnPlayBtn();
        //songsPage.isPauseBtnDisplayed();
        //WebElement pauseBtn = waitUntilPresence(By.cssSelector("[data-testid='pause-btn']"));
                //driver.findElement(By.cssSelector("[data-testid='pause-btn']"));
                //wait.until(ExpectedConditions
                     //   .presenceOfElementLocated(By.cssSelector("[data-testid='pause-btn']")));
                //(By.cssSelector("[data-testid='pause-btn']"));
        Assert.assertTrue(songsPage.isPauseBtnDisplayed());
        //WebElement equalizer = waitUntilVisible(By.cssSelector("[alt='Sound bars']"));
        Assert.assertTrue(songsPage.isEqualizerDisplayed());
    }

}
