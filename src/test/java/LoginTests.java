import POM.HomePage;
import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

//    @Test(dataProvider = "NegativeLoginTestData",dataProviderClass = TestDataProvider.class)
//    public void negativeLoginTests(String email, String password) {
//        String expectedUrl = "https://qa.koel.app/";
//        provideEmail(email);
//        providePassword(password);
//        clickLoginBtn();
//        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
//    }
    @Test
    public void loginEmptyEmailPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginBtn();
        String url = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }


    @Test
    public void loginValidEmailPassword() {
        //Steps
        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
//Step 1: Open Browser
        loginPage.provideEmail("grigore.crepciuc@testpro.io");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickLoginBtn();
        // Expected result vs Actual
        //WebElement avatarIcon = waitUntilVisible(By.cssSelector("img[class='avatar']"));
                //driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(homepage.getAvatar());
    }

    @Test
    public void loginInValidEmailPassword() {
        //Steps
        LoginPage loginPage = new LoginPage(driver);
//Step 1: Open Browser
        loginPage.provideEmail("invalidgrigore.crepciuc@testpro.io");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickLoginBtn();
//Step 5: Expected result vs Actual
        String url = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
    @Test
    public void loginValidEmailInvalidPassword() {
        //Steps
        LoginPage loginPage = new LoginPage(driver);
//Step 1: Open Browser
        loginPage.provideEmail("grigore.crepciuc@testpro.io");
        loginPage.providePassword("invalidte$t$tudent");
        loginPage.clickLoginBtn();
//Step 5: Expected result vs Actual
        String url = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
    }