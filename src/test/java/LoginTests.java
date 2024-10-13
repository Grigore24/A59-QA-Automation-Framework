import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(dataProvider = "NegativeLoginTestData",dataProviderClass = TestDataProvider.class)
    public void negativeLoginTests(String email, String password) throws InterruptedException {
        String expectedUrl = "https://qa.koel.app/";
        provideEmail(email);
        providePassword(password);
        clickLoginBtn();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
    @Test
    public void loginEmptyEmailPassword() {
        clickLoginBtn();
        String url = "https://qa.koel.app/";
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
        providePassword("te$t$tudent22");
        clickLoginBtn();
        Thread.sleep(3000);
//Step 5: Expected result vs Actual
        String url = "https://qa.koel.app/";
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
        String url = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
    }