import POM.LoginPage;
import POM.PlaylistPage;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        //WebElement successBanner = waitUntilClickable(By.cssSelector(".success"));
        Assert.assertTrue(playlistPage.isSuccesBannerIsDisplayed());
       // WebElement songName = waitUntilVisible(By.cssSelector("#playlistWrapper .song-item .title"));
         String  songText = playlistPage.getSongNameText();
        Assert.assertEquals(text, playlistPage.getSongNameText());

    }
}
