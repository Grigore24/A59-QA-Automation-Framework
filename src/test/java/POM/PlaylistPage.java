package POM;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PlaylistPage extends BasePage{
    public PlaylistPage(WebDriver givenDriver) {

        super(givenDriver);
    }
    //LOCATORS for Homework22 DeletePlaylist
    private By plusBtn = By.cssSelector("[data-testid='sidebar-create-playlist-btn']");
    private By createNewPlaylist = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");
    private By playlistNameInput = By.cssSelector(".create input");
    private By plNameInput = By.cssSelector("[id='songResultsWrapper'] [placeholder='Playlist name']");
    private By checkHeader = By.cssSelector("#playlistWrapper h1");
    private By delPlaylistBtn = By.cssSelector(".btn-delete-playlist");

    //Locators for Homework 17 addSongToPlaylist
    private By pressOnInput = By.cssSelector("[type='search']");
    private By pressClickAllViewBtn = By.xpath("//button[@data-test='view-all-songs-btn']");
    private By pressAddToBtn = By.cssSelector("[data-test='add-to-btn']");
    private By succesBannerIsDisplayed = By.cssSelector(".success");
    private By findGetSongNameTest = By.cssSelector("#playlistWrapper .song-item .title");
    ////////////Locators Homework19 DeletePlaylist with Javascript Executor/////////////
    private By pressOnPlaylist = By.cssSelector("[class='playlist playlist']");
    private By pressDeleteSelectedPlaylist = By.cssSelector("[title='Delete this playlist']");
    private By pressOkBtn = By.cssSelector(".ok");
    private By verifySuccessBanner = By.cssSelector("[class='success show']");
    ////////////////////Locators Homework21 renamePlaylist //////////////////////
    private By pressDoubleClickChoosePlaylist = By.cssSelector(".playlist:nth-child(3)");
    private By addEnterPlaylistName = By.cssSelector("input[name='name']");
    private By findGetPlaylistName = By.cssSelector(".playlist:nth-child(3)>a");
    public void createNewPlaylist(String playlistName) {
        WebElement newPlaylistNameInput = driver.findElement(plNameInput);
        newPlaylistNameInput.click();
        newPlaylistNameInput.clear();
        newPlaylistNameInput.sendKeys(playlistName);
        // click Enter
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
        System.out.println(playlistName);
    }
    ///////////////////////////////////////////////////
    public String generateRandomPlaylistName(){
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.address().country();
        return newName;
    }
    public void createNewPlaylistUsingPlusBtn(String playlistName) {
        WebElement plusButton = waitUntilClickable(plusBtn);
        plusButton.click();

        WebElement presNewPlaylistBtn = waitUntilClickable(createNewPlaylist);
        presNewPlaylistBtn.click();

        WebElement inputPlaylistName = waitUntilClickable(playlistNameInput);
        inputPlaylistName.click();
        inputPlaylistName.clear();
        inputPlaylistName.sendKeys(playlistName);
        // click Enter
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
    }
    public void checkPlayListHeader(String playlistName) {
        WebElement playlistHeader = waitUntilVisible(checkHeader);
        wait.until(ExpectedConditions
                .textToBePresentInElement(playlistHeader, playlistName));
    }
    public void clickDeletePlaylistBtn() {
        WebElement deletePlaylistBtn = waitUntilClickable(delPlaylistBtn);
        deletePlaylistBtn.click();
    }
    public List<String> getPlaylistNames() {
        List<WebElement> playlists = driver.findElements(By.cssSelector("#playlists a"));
        // get playlist names from playlist elements
        List<String> playlistNames = new ArrayList<>();

        for (int i = 0; i < playlists.size(); i++) {
            String playlistName = playlists.get(i).getText();
            playlistNames.add(playlistName);
        }
        System.out.println(playlistNames);
        return playlistNames;
    }
    //////////////////Methods for HOMEWORK 17 addSongToPlaylist//////////////

    public void findInput(String text) {
        WebElement searchInput = waitUntilClickable(pressOnInput);
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);
    }
    public void clickViewAllBtn() {
        WebElement viewAllBtn = waitUntilVisible(pressClickAllViewBtn);
        viewAllBtn.click();
    }
    public void firstSongInResults() {
        List<WebElement> songsInResults = driver.findElements(By.cssSelector(".search-results .song-item .title"));
        songsInResults.get(0).click();
    }
    public void clickAddToBtn() {
        WebElement addToBtn = waitUntilClickable(pressAddToBtn);
        addToBtn.click();
    }
    public boolean isSuccesBannerIsDisplayed(){
        return waitUntilClickable(succesBannerIsDisplayed).isDisplayed();
    }
    public String getSongNameText(){
        return driver.findElement(findGetSongNameTest).getText();
    }

    //////////////////////HOMEWORK19 DeletePlaylist with Javascript Executor/////////////////
    public void clickPlaylist() {
        WebElement playlist = waitUntilVisible(pressOnPlaylist);
        playlist.click();
    }

    public void deleteSelectedPlaylist() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement deletePlaylistBtn = waitUntilVisible(pressDeleteSelectedPlaylist);
        //driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        js.executeScript("arguments[0].click();", deletePlaylistBtn);
    }


    public void clickOkBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement okBtn = driver.findElement(pressOkBtn);
        js.executeScript("arguments[0].click();", okBtn);
    }

    public void showSuccessBanner() {
        WebElement successBanner = waitUntilVisible(verifySuccessBanner);
        //driver.findElement(By.cssSelector("[class='success show']"));
        Assert.assertTrue(successBanner.isDisplayed());
    }
    ////////////////////////Homework21 renamePlaylist//////////////////////////
    public void doubleClickChoosePlaylist() {
        WebElement playlistElement = waitUntilClickable(pressDoubleClickChoosePlaylist);
        Actions actions = new Actions(driver);
        actions.doubleClick(playlistElement).perform();
    }
    public void enterPlaylistName(String name) {
        WebElement playlistInputField = waitUntilClickable(addEnterPlaylistName);
        playlistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public String getPlaylistName() {
        WebElement playlistElement = waitUntilVisible(findGetPlaylistName);
        String name = playlistElement.getText();
        return name;
    }

}