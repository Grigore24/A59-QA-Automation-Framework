import POM.BasePage;
import POM.LoginPage;
import POM.PlaylistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Homework22 extends BaseTest {

    @Test
    public void deletePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);
        BasePage basepage = new BasePage(driver);
        String playlist = playlistPage.generateRandomPlaylistName();
        loginPage.login("grigore.crepciuc@testpro.io", "te$t$tudent");
        // CREATE PLAYLIST
        // click Plus btn
        // click Create new playlist
        // Add playlist name
        playlistPage.createNewPlaylistUsingPlusBtn(playlist);
        // check playlist name in header
        playlistPage.checkPlayListHeader(playlist);
        // delete playlist
        playlistPage.clickDeletePlaylistBtn();
        // verify banner
        Assert.assertTrue(basepage.IsSuccesBannerDisplayed());
        // refresh page
        basepage.refreshPage();
        // get all playlist elements
        List<String> playlistNames = playlistPage.getPlaylistNames();
        // assert playlist was deleted
        Assert.assertFalse(playlistNames.contains(playlist));
    }

}
