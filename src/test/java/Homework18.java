import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
public class Homework18 extends BaseTest {
    @Test
    public void playSong()  {
        login("grigore.crepciuc@testpro.io", "te$t$tudent");
        pressOnPlayBtn();
        WebElement pauseBtn = driver.findElement(By.cssSelector("[class='pause']"));
        Assert.assertTrue(pauseBtn.isDisplayed());
        WebElement equalizer = driver.findElement(By.cssSelector("[alt='Sound bars']"));
        Assert.assertTrue(equalizer.isDisplayed());
    }

    private void pressOnPlayBtn() {
        WebElement buttonPlayOrResume = driver.findElement(By.cssSelector("[title='Play or resume']"));
        new Actions(driver)
                .moveToElement(buttonPlayOrResume)
                .perform();
        buttonPlayOrResume.click();
    }
}
