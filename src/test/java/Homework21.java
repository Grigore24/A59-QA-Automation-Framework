import POM.LoginPage;
import POM.PlaylistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework21 extends BaseTest {

    @Test
    public void renamePlaylist() {
        // double click
        String playlistName = "Sun And Wind";
        LoginPage loginPage = new LoginPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);
        loginPage.login("grigore.crepciuc@testpro.io", "te$t$tudent");
        playlistPage.doubleClickChoosePlaylist();
        playlistPage.enterPlaylistName(playlistName);
        String newName = playlistPage.getPlaylistName();
        Assert.assertEquals(playlistName, playlistPage.getPlaylistName(), "=== PlaylistNames expected to be equals ===");
    }


}
