import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(dataProvider = "NegativeLoginTestData",dataProviderClass = TestDataProvider.class)
    public void negativeLoginTests(String email, String password) {
        String expectedUrl = "https://qa.koel.app/";
        provideEmail(email);
        providePassword(password);
        clickLoginBtn();
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
    @Test
    public void loginEmptyEmailPassword() {
        clickLoginBtn();
        String url = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }


    @Test
    public void loginValidEmailPassword() {
        //Steps
//Step 1: Open Browser
        provideEmail("grigore.crepciuc@testpro.io");
        providePassword("te$t$tudent");
        clickLoginBtn();
        // Expected result vs Actual
        WebElement avatarIcon = waitUntilVisible(By.cssSelector("img[class='avatar']"));
                //driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test
    public void loginInValidEmailPassword() {
        //Steps
//Step 1: Open Browser
        provideEmail("invalidgrigore.crepciuc@testpro.io");
        providePassword("te$t$tudent");
        clickLoginBtn();
//Step 5: Expected result vs Actual
        String url = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
    @Test
    public void loginValidEmailInvalidPassword() {
        //Steps
//Step 1: Open Browser
        provideEmail("grigore.crepciuc@testpro.io");
        providePassword("invalidte$t$tudent");
        clickLoginBtn();
//Step 5: Expected result vs Actual
        String url = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
    }