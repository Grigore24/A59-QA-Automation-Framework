import POM.LoginPage;
import POM.SongsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
public class Homework18 extends BaseTest {
    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(driver);
        SongsPage songsPage = new SongsPage(driver);
        loginPage.login("grigore.crepciuc@testpro.io", "te$t$tudent");
        songsPage.pressOnPlayBtn();
        WebElement pauseBtn = waitUntilVisible(By.cssSelector("[data-testid='pause-btn']"));
        Assert.assertTrue(pauseBtn.isDisplayed());
        WebElement equalizer = waitUntilVisible(By.cssSelector("[alt='Sound bars']"));
        Assert.assertTrue(equalizer.isDisplayed());
    }


}
