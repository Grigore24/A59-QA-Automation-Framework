import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
@Test
    public void loginValidEmailPassword() throws InterruptedException {
        //Pre-conditions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //Chrome Driver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Steps
//Step 1: Open Browser
        String url = "https://qa.koel.app/";
        driver.get(url);
//Step 2: Enter Email
        WebElement emailField = driver.findElement(By.cssSelector("input[type = 'email']"));
        emailField.clear();
        emailField.sendKeys("grigore.crepciuc@testpro.io");
//Step 3: Enter password
        WebElement passwordField = driver.findElement(By.cssSelector("input[type = 'password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
//Step 4: Click LoginBtn
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        Thread.sleep(3000);
//Step 5: Expected result vs Actual
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
        //Close browser
        driver.quit();
    }

    @Test
    public void loginInValidEmailPassword() throws InterruptedException {
        //Pre-conditions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //Chrome Driver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Steps
//Step 1: Open Browser
        String url = "https://qa.koel.app/";
        driver.get(url);
//Step 2: Enter Email
        WebElement emailField = driver.findElement(By.cssSelector("input[type = 'email']"));
        emailField.clear();
        emailField.sendKeys("incorrectgrigore.crepciuc@testpro.io");
//Step 3: Enter password
        WebElement passwordField = driver.findElement(By.cssSelector("input[type = 'password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
//Step 4: Click LoginBtn
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        Thread.sleep(3000);
//Step 5: Expected result vs Actual
        Assert.assertEquals(driver.getCurrentUrl(),url);
        //Close browser
        driver.quit();
    }
    @Test
    public void loginValidEmailInvalidPassword() throws InterruptedException {
        //Pre-conditions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //Chrome Driver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Steps
//Step 1: Open Browser
        String url = "https://qa.koel.app/";
        driver.get(url);
//Step 2: Enter Email
        WebElement emailField = driver.findElement(By.cssSelector("input[type = 'email']"));
        emailField.clear();
        emailField.sendKeys("grigore.crepciuc@testpro.io");
//Step 3: Enter password
        WebElement passwordField = driver.findElement(By.cssSelector("input[type = 'password']"));
        passwordField.clear();
        passwordField.sendKeys("incorrectte$t$tudent");
//Step 4: Click LoginBtn
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        Thread.sleep(3000);
//Step 5: Expected result vs Actual
        Assert.assertEquals(driver.getCurrentUrl(),url);
        //Close browser
        driver.quit();
    }
    }