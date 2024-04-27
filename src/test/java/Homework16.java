import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class Homework16 extends BaseTest {
    @Test
    public void testRegistrationNavigation(){
        LoginPage loginPage = new LoginPage(getDriver());
        String expectedRegistrationUrl = "https://qa.koel.app/registration";
        loginPage.findRegistrationLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedRegistrationUrl);

    }

}
