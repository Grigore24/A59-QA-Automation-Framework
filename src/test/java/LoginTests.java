import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {
        clickLoginBtn();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }


    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        //Steps
//Step 1: Open Browser
        provideEmail("grigore.crepciuc@testpro.io");
        providePassword("te$t$tudent22");
        clickLoginBtn();
        Thread.sleep(3000);
        // Expected result vs Actual
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test
    public void loginInValidEmailPassword() throws InterruptedException {
        //Steps
//Step 1: Open Browser
        provideEmail("invalidgrigore.crepciuc@testpro.io");
        providePassword("te$t$tudent");
        clickLoginBtn();
        Thread.sleep(3000);
//Step 5: Expected result vs Actual
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
    @Test
    public void loginValidEmailInvalidPassword() throws InterruptedException {
        //Steps
//Step 1: Open Browser
        provideEmail("grigore.crepciuc@testpro.io");
        providePassword("invalidte$t$tudent");
        clickLoginBtn();
        Thread.sleep(3000);
//Step 5: Expected result vs Actual
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
    }