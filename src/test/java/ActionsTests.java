import POM.LoginPage;
import POM.SongsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ActionsTests extends BaseTest {
  /*  @Test
    public void playSongTest()  {
        LoginPage loginPage = new LoginPage(driver);
        // hover over in clickPlayBtn
        loginPage.login("grigore.crepciuc@testpro.io", "te$t$tudent");
        clickFooterPlayBtn();
        Assert.assertTrue(pauseBtnExists());


        // Comparing numbers of elements example
        List<WebElement> songs = driver.findElements(By.cssSelector("[data-test='song-card']"));

        int songsNumberBefore = songs.size();
        System.out.println(songsNumberBefore);
        // Just an example: here we would add or delete an element but we didn't
        int songsNumberAfter = songs.size();
        System.out.println(songsNumberAfter);

        // Soft assert example
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(songsNumberBefore == songsNumberAfter,
                "=== Songs number before should be equal songs number after ===");
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/#!/queue");
        System.out.println("Hello world");
        //softAssert.assertAll();
    }
    public void clickFooterPlayBtn() {
        Actions action = new Actions(driver);
        WebElement playBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='play-btn']")));
        //driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        action
                .moveToElement(playBtn)
                .perform();
        playBtn.click();
    }

    public boolean pauseBtnExists() {
        return waitUntilClickable(By.cssSelector("[data-testid='pause-btn']")).isDisplayed();
        //driver.findElement(By.cssSelector("[data-testid='pause-btn']")).isDisplayed();
    }*/
////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void playSongFromListTest()  {
        LoginPage loginPage = new LoginPage(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());
        loginPage.login("grigore.crepciuc@testpro.io", "te$t$tudent");
        songsPage.goToAllSongs();
        // right click on first song
        songsPage.rightClickOnFirstSong();
        // click play button
        songsPage.clickPlayBtn();
        // verify
        Assert.assertTrue(songsPage.isEqualizerDisplayed());
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////

//    @Test
//    public void countSongsInPlaylist() {
//
//        login("grigore.crepciuc@testpro.io", "te$t$tudent");
//        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
//        playlist.click();
//        List<WebElement> songs = driver.findElements(By.cssSelector("#playlistWrapper .song-item"));
//        int number = songs.size();
//        Assert.assertEquals(number, 1); // can fail, depends on current number. This is just an example
//
//    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void countSongsInsidePlaylist(){
        LoginPage loginPage = new LoginPage(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());
        loginPage.login("grigore.crepciuc@testpro.io", "te$t$tudent");
        choosePlaylistByName("ara");
        displayAllSongs();
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
    }
    public void choosePlaylistByName(String playlistName){
       waitUntilVisible(By.xpath("//a[contains(text(),'"+ playlistName +"')]")).click();
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+ playlistName +"')]"))).click();
                                //(By.cssSelector("[href='#!/playlist/93973']")))
    }
    public void displayAllSongs(){
        List<WebElement>songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        //count and display songs names
        System.out.println("Number of songs in the playlist:"+ countSongs());
        for(WebElement e : songList){
            System.out.println(e.getText());
        }
    }
    public int countSongs(){
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }
    public String getPlaylistDetails(){
        return waitUntilVisible(By.cssSelector("span.meta.text-secondary span.meta")).getText();
                //driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }
}
