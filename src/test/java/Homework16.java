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

        // Steps
        String expectedRegistrationUrl = "https://qa.koel.app/registration";
        navigateToPage("https://qa.koel.app/");
        findRegistrationLink();
        Assert.assertEquals(driver.getCurrentUrl(), expectedRegistrationUrl);

    }
    private void findRegistrationLink() {
        WebElement registrationLink = driver.findElement(By.cssSelector("[href='registration']"));
        registrationLink.click();
    }

}
