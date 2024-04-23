import POM.LoginPage;
import POM.PlaylistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);
//      Added ChromeOptions argument below to fix websocket error
        loginPage.login("grigore.crepciuc@testpro.io", "te$t$tudent");
        playlistPage.clickPlaylist();
        playlistPage.deleteSelectedPlaylist();
        playlistPage.clickOkBtn();
        playlistPage.showSuccessBanner();
    }


    public void clickPlaylist() {
        WebElement playlist = waitUntilVisible(By.cssSelector("[class='playlist playlist']"));
        playlist.click();
    }

    public void deleteSelectedPlaylist() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement deletePlaylistBtn = waitUntilVisible(By.cssSelector("[title='Delete this playlist']"));
                //driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        js.executeScript("arguments[0].click();", deletePlaylistBtn);
    }

    public void waitCommand() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void clickOkBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement okBtn = driver.findElement(By.cssSelector(".ok"));
        js.executeScript("arguments[0].click();", okBtn);
    }

    public void showSuccessBanner() {
        WebElement successBanner = waitUntilVisible(By.cssSelector("[class='success show']"));
                //driver.findElement(By.cssSelector("[class='success show']"));
        Assert.assertTrue(successBanner.isDisplayed());
    }
}

