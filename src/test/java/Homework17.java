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
        String text = "Dark Days";
        String playlistName = generateRandomPlaylistName();
        // login
        login("grigore.crepciuc@testpro.io", "te$t$tudent");
        // search for song
        findInput(text);
        // click results view all button
        clickViewAllBtn();
        // click first song
        firstSongInResults();
        // click Add To
        clickAddToBtn();
        // create new playlist
        createNewPlaylist(playlistName);
        // assertions - success banner and song name in playlist
        //WebElement successBanner = driver.findElement(By.cssSelector(".success"));
        WebElement successBanner = waitUntilClickable(By.cssSelector(".success"));
        Assert.assertTrue(successBanner.isDisplayed());
        WebElement songName = waitUntilVisible(By.cssSelector("#playlistWrapper .song-item .title"));
        String songText = songName.getText();
        Assert.assertEquals(text, songText);

    }

    public void createNewPlaylist(String playlistName) {
        WebElement newPlaylistNameInput = waitUntilVisible(By.cssSelector("[id='songResultsWrapper'] [placeholder='Playlist name']"));
                //driver.findElement(By.cssSelector("[id='songResultsWrapper'] [placeholder='Playlist name']"));
        newPlaylistNameInput.click();
        newPlaylistNameInput.clear();
        newPlaylistNameInput.sendKeys(playlistName);
        // click Enter
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
        System.out.println(playlistName);
    }

    public void clickAddToBtn() {
        WebElement addToBtn = waitUntilClickable(By.cssSelector("[data-test='add-to-btn']"));
        addToBtn.click();
    }

    public void firstSongInResults() {
        List<WebElement> songsInResults = driver.findElements(By.cssSelector(".search-results .song-item .title"));
        songsInResults.get(0).click();
    }

    public void clickViewAllBtn() {
        WebElement viewAllBtn = waitUntilVisible(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }

    public void findInput(String text) {
        WebElement searchInput = waitUntilClickable(By.cssSelector("[type='search']"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);
    }
}
