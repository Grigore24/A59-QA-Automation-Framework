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
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());
//      Added ChromeOptions argument below to fix websocket error
        loginPage.login("grigore.crepciuc@testpro.io", "te$t$tudent");
        playlistPage.clickPlaylist();
        playlistPage.deleteSelectedPlaylist();
        playlistPage.clickOkBtn();
        Assert.assertTrue(playlistPage.isSuccesBannerIsDisplayed());
//    public void showSuccessBanner() {
//        WebElement successBanner = waitUntilVisible(By.cssSelector("[class='success show']"));
//                //driver.findElement(By.cssSelector("[class='success show']"));
//        Assert.assertTrue(successBanner.isDisplayed());
   }
}

