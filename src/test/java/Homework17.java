import POM.LoginPage;
import POM.PlaylistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);
        String text = "Dark Days";
        String playlistName = playlistPage.generateRandomPlaylistName();
        // login
        loginPage.login("grigore.crepciuc@testpro.io", "te$t$tudent");
        // search for song
        playlistPage.findInput(text);
        // click results view all button
        playlistPage.clickViewAllBtn();
        // click first song
        playlistPage.firstSongInResults();
        // click Add To
        playlistPage.clickAddToBtn();
        // create new playlist
        playlistPage.createNewPlaylist(playlistName);
        // assertions - success banner and song name in playlist
        //WebElement successBanner = driver.findElement(By.cssSelector(".success"));
        WebElement successBanner = waitUntilClickable(By.cssSelector(".success"));
        Assert.assertTrue(successBanner.isDisplayed());
        WebElement songName = waitUntilVisible(By.cssSelector("#playlistWrapper .song-item .title"));
        String songText = songName.getText();
        Assert.assertEquals(text, songText);

    }

}
